package BMS.Book.My.Show.Service;

import BMS.Book.My.Show.Models.User;
import BMS.Book.My.Show.Repository.UserRepository;
import BMS.Book.My.Show.RequestDto.UserDto;
import BMS.Book.My.Show.ResponesDto.UserRdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {



    @Autowired
    UserRepository userRepository;
    public String addUser(UserDto userDto) {
        User user=User.builder().name(userDto.getName()).mobile(userDto.getMobile()).build();
        try {
            userRepository.save(user);
        }
        catch(Exception e){
            return "Error occured while adding user";
        }
        return "User added sucessfully";
    }

    public List<UserRdto> GetByName(String name) {
        List<User> ListOfUser=userRepository.findByName(name);
        List<UserRdto> list=new ArrayList<>();
        for(User user: ListOfUser){
            UserRdto userRdto=UserRdto.builder().name(user.getName()).mobile(user.getMobile()).build();
            list.add(userRdto);
        }
        return list;
    }

    public List<UserRdto> GetAllUsers() {
        List<User> ListOfUser=userRepository.findAll();
        List<UserRdto> list=new ArrayList<>();
        for(User user: ListOfUser){
            UserRdto userRdto=UserRdto.builder().name(user.getName()).mobile(user.getMobile()).build();
            list.add(userRdto);
        }
        return list;
    }

    public String RemoveById(int id) throws Exception{
        User user=userRepository.findById(id).get();
        if(user==null){
            throw new Exception("User With that Id is Not Present");
        }
        else{
            userRepository.deleteById(id);
            return "User Succesfully removed";
        }

    }
    public String AllUser(){
        userRepository.deleteAll();
        return "All Users Are Removed From Data Base Succesfully";
    }
}
