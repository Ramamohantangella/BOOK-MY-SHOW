package BMS.Book.My.Show.ResponesDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TheaterResponse {

    private String name;


    private String city;


    private String adress;


}
