package BMS.Book.My.Show.Service;

import BMS.Book.My.Show.Models.Movie;
import BMS.Book.My.Show.Models.Show;
import BMS.Book.My.Show.Models.Theater;
import BMS.Book.My.Show.Models.TheaterSeats;
import BMS.Book.My.Show.Repository.MovieRepository;
import BMS.Book.My.Show.Repository.TheaterRepository;
import BMS.Book.My.Show.RequestDto.TheaterRequest;
import BMS.Book.My.Show.ResponesDto.TheaterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsService theaterSeatsService;

    @Autowired
    MovieRepository movieRepository;

    public String AddTheater(TheaterRequest theaterRequest) {
        Theater theater=Theater.builder().city(theaterRequest.getCity()).name(theaterRequest.getName()).adress(theaterRequest.getAdress()).build();
        List<TheaterSeats> SeatsList=theaterSeatsService.AddTheaterSeats(theater);
        for(TheaterSeats x: SeatsList){
            x.setTheater(theater);
        }
        theater.setListofTheaterSeats(SeatsList);
        theaterRepository.save(theater);
        return "Theater added succesfully";

    }

    public TheaterResponse getTheater(int id) {
        Theater theater=theaterRepository.findById(id).get();
        TheaterResponse theaterResponse=TheaterResponse.builder().name(theater.getName()).adress(theater.getAdress()).city(theater.getCity()).build();
       return theaterResponse;
    }

    public List<TheaterResponse> getAllTheater() {
        List<Theater> allTheaters=theaterRepository.findAll();
        List<TheaterResponse> list=new ArrayList<>();
        for(Theater theater: allTheaters){
            TheaterResponse theaterResponse=TheaterResponse.builder().name(theater.getName()).adress(theater.getAdress()).city(theater.getCity()).build();
            list.add(theaterResponse);

        }
        return list;
    }

    public List<String> getByMovie(String name) {
        Movie movie=movieRepository.findByName(name);
        List<Show> ShowList=movie.getShowList();
        List<String> TheaterList=new ArrayList<>();
        for(Show show: ShowList){
            TheaterList.add(show.getTheater().getName());
        }
        return TheaterList;
    }

    public String DeleteById(int id) throws Exception {
        Theater theater=theaterRepository.findById(id).get();
        if(theater==null){
            throw new Exception("Theater Does Not Exist With That Id");
        }
        else{
            theaterRepository.deleteById(id);
            return "Theater Removed Succesfully";

        }
    }

    public String DeleteAll() {
        theaterRepository.deleteAll();
        return "All Theaters Removed Succesfully";
    }
}
