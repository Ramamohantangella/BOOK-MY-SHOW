package BMS.Book.My.Show.Service;

import BMS.Book.My.Show.Enum.SeatType;
import BMS.Book.My.Show.Models.Theater;
import BMS.Book.My.Show.Models.TheaterSeats;
import BMS.Book.My.Show.Repository.TheaterSeatsRepository;
import BMS.Book.My.Show.RequestDto.TheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterSeatsService {

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    public List<TheaterSeats> AddTheaterSeats(Theater theater) {
        TheaterSeats[][] theaterSeats=new TheaterSeats[5][4];
        List<TheaterSeats> list=new ArrayList<>();
        int j=0;
        for(int i=0;i<5;i++){
            if(j==4){
                j=0;
            }
            for(TheaterSeats theaterSeats1: theaterSeats[i]){
                TheaterSeats theaterSeats2=new TheaterSeats();
                String s= String.valueOf(i+1)+(char)(97+j);
                if(i<=1){

                    theaterSeats2.setSeatType(SeatType.PLATINUM);
                    theaterSeats2.setSeatNo(s);
                    theaterSeats2.setRate(200);
                }
                else{
                    theaterSeats2.setSeatType(SeatType.CLASSIC);
                    theaterSeats2.setSeatNo(s);
                    theaterSeats2.setRate(150);
                }
                list.add(theaterSeats2);
                theaterSeatsRepository.save(theaterSeats2);
                j++;
            }
        }
       return list;
    }
}
