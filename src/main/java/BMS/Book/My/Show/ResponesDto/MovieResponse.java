package BMS.Book.My.Show.ResponesDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class MovieResponse {
    private String name;

    private Date ReleaseDate;

    private String Duration;

}
