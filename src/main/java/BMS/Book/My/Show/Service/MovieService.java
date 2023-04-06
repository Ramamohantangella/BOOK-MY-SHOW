package BMS.Book.My.Show.Service;

import BMS.Book.My.Show.Models.Movie;
import BMS.Book.My.Show.Repository.MovieRepository;
import BMS.Book.My.Show.RequestDto.MovieRequest;
import BMS.Book.My.Show.ResponesDto.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String AddMovie(MovieRequest movieRequest) {
        Movie movie=new Movie();
        movie.setName(movieRequest.getName());
        movie.setDuration(movieRequest.getDuration());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movieRepository.save(movie);
        return "Movie succesfully added";
    }

    public MovieResponse getMovieByName(String name) {
        Movie movie=movieRepository.findByName(name);

        MovieResponse movieResponse=MovieResponse.builder().name(movie.getName()).Duration(movie.getDuration()).ReleaseDate(movie.getReleaseDate()).build();
        return movieResponse;
    }


    public List<MovieResponse> getAllMovies() {
        List<Movie> list=movieRepository.findAll();
        List<MovieResponse> newlist=new ArrayList<>();
        for(Movie movie: list){
            MovieResponse movieResponse=MovieResponse.builder().name(movie.getName()).Duration(movie.getDuration()).ReleaseDate(movie.getReleaseDate()).build();
            newlist.add(movieResponse);
        }
        return newlist;
    }

    public String RemoveById(int id) throws Exception{
        Movie movie=movieRepository.findById(id).get();
        if(movie==null){
            throw new Exception("There no Movie Exist with That Name and Id");
        }
        else{
            movieRepository.deleteById(id);
            return "Movie Deleted Succesfully";
        }

    }

    public String RemoveAll() {
        movieRepository.deleteAll();
        return "All Movie Deleted";
    }
}
