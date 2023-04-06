package BMS.Book.My.Show.Controllers;


import BMS.Book.My.Show.Models.Ticket;
import BMS.Book.My.Show.RequestDto.TicketRequest;
import BMS.Book.My.Show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ticket")
public class TicketContoller {

    @Autowired
    TicketService ticketService;

    @PostMapping("/bookticket")
    public ResponseEntity<String> BookTicket(@RequestBody TicketRequest ticketRequest){
        try {
            String ans = ticketService.BookTicket(ticketRequest);
            return new ResponseEntity<>(ans, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Requested Seats Are Not Available" ,HttpStatus.CREATED);
        }


    }
    @GetMapping("/geytTickets")
    public ResponseEntity<List<Ticket>> getListOfTickets(@RequestParam int userid){
        List<Ticket> TicketList=ticketService.getListOfTickets(userid);
        return new ResponseEntity<>(TicketList,HttpStatus.OK);
    }
    @DeleteMapping("/CancellTickets")
    public ResponseEntity<String> CancelTicket(@RequestParam int id){
        try{
            String ans=ticketService.CancelTicket(id);
            return new ResponseEntity<>(ans, HttpStatus.OK);

        }
        catch(Exception e){
            return new ResponseEntity<>( "Tickets Are Failed to cancel",HttpStatus.OK);
        }
    }




}

