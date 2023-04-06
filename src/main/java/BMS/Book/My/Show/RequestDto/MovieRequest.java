package BMS.Book.My.Show.RequestDto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieRequest {

    private String name;

    private Date releaseDate;

    private String duration;

}
