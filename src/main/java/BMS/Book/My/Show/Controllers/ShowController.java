package BMS.Book.My.Show.Controllers;

import BMS.Book.My.Show.RequestDto.ShowRequest;
import BMS.Book.My.Show.ResponesDto.ShowResponse;
import BMS.Book.My.Show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Show")

public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/addshow")
    public ResponseEntity<String> AddShow(@RequestBody ShowRequest showRequest){
       // System.out.print(showRequest.getMoviename()+""+showRequest.getTheaterid()+""+showRequest.getShowDate());
        String ans=showService.AddShow(showRequest);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    @DeleteMapping("/DeleteById")
    public ResponseEntity<String> DeletebyId(@RequestParam int id){
        try{
            String ans=showService.DeletebyId(id);
            return new ResponseEntity<>(ans,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No Show Exist With That Id",HttpStatus.OK);
        }
    }


}
