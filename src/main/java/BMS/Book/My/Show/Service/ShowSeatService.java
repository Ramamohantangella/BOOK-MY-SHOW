package BMS.Book.My.Show.Service;

import BMS.Book.My.Show.Models.ShowSeats;
import BMS.Book.My.Show.Models.TheaterSeats;
import BMS.Book.My.Show.Repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowSeatService {



    @Autowired
    ShowSeatRepository showSeatRepository;
    public List<ShowSeats> createShowSeats(List<TheaterSeats> theaterSeatsList) {
        List<ShowSeats> list=new ArrayList<>();
        for(TheaterSeats theaterSeats: theaterSeatsList){
            ShowSeats s=ShowSeats.builder().SeatNo(theaterSeats.getSeatNo()).seattype(theaterSeats.getSeatType()).build();
            list.add(s);
        }
        showSeatRepository.saveAll(list);
        return list;
    }
}
