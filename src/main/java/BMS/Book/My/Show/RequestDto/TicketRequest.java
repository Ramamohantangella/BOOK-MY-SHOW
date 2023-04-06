package BMS.Book.My.Show.RequestDto;


import lombok.Data;

import java.util.List;

@Data
public class TicketRequest {

    private List<String> orderedSeats;

    private int userId;

    private int showId;
}
