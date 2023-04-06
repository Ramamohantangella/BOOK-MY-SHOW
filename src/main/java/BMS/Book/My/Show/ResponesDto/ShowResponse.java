package BMS.Book.My.Show.ResponesDto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponse {

    private LocalDate showdate;

    private LocalTime showTime;
}
