package BMS.Book.My.Show.Controllers;

import BMS.Book.My.Show.RequestDto.UserDto;
import BMS.Book.My.Show.ResponesDto.UserRdto;
import BMS.Book.My.Show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/adduser")
    public ResponseEntity <String> addUser(@RequestBody UserDto userDto){
        String ans=userService.addUser(userDto);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    @GetMapping("/getUserBYName")
    public ResponseEntity<List<UserRdto>> GetByName(@RequestParam String Name){
        List<UserRdto> ResponseUserList=userService.GetByName(Name);
        return new ResponseEntity<>(ResponseUserList, HttpStatus.OK);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserRdto>> findAllUsers(){
        List<UserRdto> ResponseUserList=userService.GetAllUsers();
        return new ResponseEntity<>(ResponseUserList, HttpStatus.OK);
    }
    @DeleteMapping("/removebyid")
    public ResponseEntity<String> RemoveById(@RequestParam int id){
        try{
            String ans=userService.RemoveById(id);
            return new ResponseEntity<>(ans, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("No user Present With That Id",HttpStatus.OK);
        }
    }
    @DeleteMapping("/removeallusers")
    public ResponseEntity<String> AllUser(){
        String ans=userService.AllUser();
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }

}
