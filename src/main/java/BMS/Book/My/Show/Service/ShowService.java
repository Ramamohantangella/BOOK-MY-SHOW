package BMS.Book.My.Show.Service;

import BMS.Book.My.Show.Models.*;
import BMS.Book.My.Show.Repository.MovieRepository;
import BMS.Book.My.Show.Repository.ShowRepository;
import BMS.Book.My.Show.Repository.TheaterRepository;
import BMS.Book.My.Show.RequestDto.ShowRequest;
import BMS.Book.My.Show.ResponesDto.ShowResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;


    @Autowired
    ShowSeatService showSeatService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;
    public String AddShow(ShowRequest showRequest) {
        try {

            Show show = Show.builder().showDate(showRequest.getShowDate()).showTime(showRequest.getShowTime()).multiplier(showRequest.getMultiplier()).build();
            Movie movie = movieRepository.findByName(showRequest.getMoviename());
            show.setMovie(movie);

            Theater theater = theaterRepository.findById(showRequest.getTheaterid()).get();
            show.setTheater(theater);

            List<Show> Showlist = movie.getShowList();
            if (Showlist == null) {
                Showlist = new ArrayList<>();
            }
            Showlist.add(show);
            movie.setShowList(Showlist);

            List<Show> TheaterShowList = theater.getShowList();
            if (TheaterShowList == null) {
                TheaterShowList = new ArrayList<>();
            }
            TheaterShowList.add(show);
            theater.setShowList(TheaterShowList);

            List<TheaterSeats> TheaterSeatList = theater.getListofTheaterSeats();
            List<ShowSeats> ShowSeatslist = showSeatService.createShowSeats(TheaterSeatList);
            show.setShowSeatList(ShowSeatslist);
            for (ShowSeats s : ShowSeatslist) {
                s.setShow(show);
            }
            theaterRepository.save(theater);
            movieRepository.save(movie);
            showRepository.save(show);
        }
        catch (Exception e){
            return "Problem in adding the Show "+e.toString();
        }
        return "Show added sucessfully";

    }

    public String DeletebyId(int id) {
        Show show=showRepository.findById(id).get();
        if(show==null){
             return "No Show Exist With That Id";
        }
        else{
            showRepository.deleteById(id);
            return "Show Deleted Succesfully";
        }
    }
}
