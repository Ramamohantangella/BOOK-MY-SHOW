package BMS.Book.My.Show.Controllers;

import BMS.Book.My.Show.Models.Theater;
import BMS.Book.My.Show.RequestDto.MovieRequest;
import BMS.Book.My.Show.RequestDto.TheaterRequest;
import BMS.Book.My.Show.ResponesDto.TheaterResponse;
import BMS.Book.My.Show.Service.MovieService;
import BMS.Book.My.Show.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Theater")
public class TheaterContoller {


    @Autowired
    TheaterService theaterService;
    @PostMapping("/AddTheater")
    public ResponseEntity<String> AddTheater(@RequestBody TheaterRequest theaterRequest){
        String ans=theaterService.AddTheater(theaterRequest);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    @GetMapping("/getTheaterById")
    public ResponseEntity<TheaterResponse> getTheater(@RequestParam int id){
        TheaterResponse theaterResponse=theaterService.getTheater(id);
        return new ResponseEntity<>(theaterResponse,HttpStatus.OK);
    }
    @GetMapping("/getAllTheaters")
    public ResponseEntity<List<TheaterResponse>> getAllTheater(){
        List<TheaterResponse> ListofTheaters=theaterService.getAllTheater();
        return new ResponseEntity<>(ListofTheaters,HttpStatus.OK);
    }
    @GetMapping("/get-listOfTheaters-ByMovie")
    public ResponseEntity<List<String>> getByMovie(@RequestParam String name){
        List<String> TheaterList=theaterService.getByMovie(name);
        return new ResponseEntity<>(TheaterList,HttpStatus.OK);
    }
    @DeleteMapping("/DeleteTheaterById")
    public ResponseEntity<String> DeleteById(@RequestParam int id){
        try {
            String ans = theaterService.DeleteById(id);
            return new ResponseEntity<>(ans, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Theater Does Not Exist With That Id",HttpStatus.OK);
        }
    }
    @DeleteMapping("/DeleteAll")
    public ResponseEntity<String> DeleteAll(){
        String ans = theaterService.DeleteAll();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }


}
