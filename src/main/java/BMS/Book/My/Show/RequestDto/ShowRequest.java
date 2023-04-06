package BMS.Book.My.Show.RequestDto;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequest {

    private LocalDate showDate;


    private LocalTime showTime;

    private double multiplier;

    private String moviename;

    private int theaterid;


}
