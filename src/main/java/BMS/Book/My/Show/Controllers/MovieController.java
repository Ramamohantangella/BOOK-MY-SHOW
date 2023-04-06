package BMS.Book.My.Show.Controllers;

import BMS.Book.My.Show.Models.Movie;
import BMS.Book.My.Show.RequestDto.MovieRequest;
import BMS.Book.My.Show.ResponesDto.MovieResponse;
import BMS.Book.My.Show.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addmovie")
    public ResponseEntity<String> AddMovie(@RequestBody MovieRequest movieRequest){
        String ans=movieService.AddMovie(movieRequest);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/getMovieByname")
    public ResponseEntity<MovieResponse> getMovieByName(@RequestParam String name){
        MovieResponse movieResponse=movieService.getMovieByName( name);
        return new ResponseEntity<>(movieResponse,HttpStatus.OK);

    }
    @GetMapping("/getALLMovies")
    public ResponseEntity<List<MovieResponse>>getAllMovies(){
        List<MovieResponse> list=movieService.getAllMovies();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @DeleteMapping("/RemoveByIdAndName")
    public ResponseEntity<String>RemoveById(@RequestParam int id){
        try {
            String ans = movieService.RemoveById(id);
            return new ResponseEntity<>(ans, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>( "There no Movie Exist with That Name and Id",HttpStatus.OK);
        }
    }
    @DeleteMapping("/removeAll")
    public ResponseEntity<String> RemoveAll(){
        String ans = movieService.RemoveAll();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }


}
