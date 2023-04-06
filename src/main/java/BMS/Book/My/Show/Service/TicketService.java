package BMS.Book.My.Show.Service;


import BMS.Book.My.Show.Enum.SeatType;
import BMS.Book.My.Show.Models.Show;
import BMS.Book.My.Show.Models.ShowSeats;
import BMS.Book.My.Show.Models.Ticket;
import BMS.Book.My.Show.Models.User;
import BMS.Book.My.Show.Repository.ShowRepository;
import BMS.Book.My.Show.Repository.ShowSeatRepository;
import BMS.Book.My.Show.Repository.TicketRepository;
import BMS.Book.My.Show.Repository.UserRepository;
import BMS.Book.My.Show.RequestDto.TicketRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;


    public String BookTicket(TicketRequest ticketRequest)throws Exception {
      // try {
            //retriving data from dto
            List<String> orderedSeats = ticketRequest.getOrderedSeats();
            User user = userRepository.findById(ticketRequest.getUserId()).get();
            Show show = showRepository.findById(ticketRequest.getShowId()).get();

            //checking seats booked
            List<ShowSeats> listOfSeats = show.getShowSeatList();
            if(orderedSeats==null){
                return "give some seats";
            }

            List<ShowSeats> SeatsBooked = new ArrayList<>();

            for (ShowSeats s : listOfSeats) {
                String seatNumber = s.getSeatNo();
                if (s.isBooked() == false && orderedSeats.contains(seatNumber)) {
                    SeatsBooked.add(s);
                }
            }

            if (SeatsBooked.size() != orderedSeats.size()) {
                throw new Exception( "Requested Seats Are Not Available");
            }

            //if book not throw exception
            Ticket ticket = new Ticket();
            double Amount = 0;
            double Multiplier = show.getMultiplier();
            String AllocatedSeats = "";
            for (ShowSeats s : SeatsBooked) {
                s.setBooked(true);
                s.setBookedAt(new Date());
                s.setTicket(ticket);
                //s.setShow(show);

                String seatNo = s.getSeatNo();
                AllocatedSeats = AllocatedSeats + seatNo + ",";
                if (seatNo.charAt(0) == '1' || seatNo.charAt(0) == '2') {
                    s.setSeattype(SeatType.PLATINUM);
                    Amount = Amount + (200) * Multiplier;
                } else {
                    s.setSeattype(SeatType.CLASSIC);
                    Amount = Amount + (150) * Multiplier;
                }

            }
            ticket.setBookedAt(new Date());
            ticket.setAmount((int) Amount);
            ticket.setUser(user);
            System.out.print(AllocatedSeats);
            ticket.setAllocatedSeats(AllocatedSeats);
            ticket.setShowSeatsList(SeatsBooked);
            ticket.setShow(show);
            ticketRepository.save(ticket);
            return "Ticket Booked Succesfully";
       // }


    }

    public String CancelTicket(int id) throws Exception {
        Ticket ticket=ticketRepository.findById(id).get();

        if(ticket==null){
            return "Tickets Are Failed to cancel";
        }
        List<ShowSeats> ShowSeatsList=ticket.getShowSeatsList();
        for(ShowSeats seats: ShowSeatsList){
            seats.setBooked(false);
            seats.setTicket(null);
            seats.setBookedAt(null);

        }
        showSeatRepository.saveAll(ShowSeatsList);
        ticket.setShowSeatsList(null);
        ticketRepository.deleteById(id);
        return "Tickets are Succesfully cancelled";
    }

    public List<Ticket> getListOfTickets(int userid) {
        User user=userRepository.findById(userid).get();
        return user.getTicketsList();
    }
}
