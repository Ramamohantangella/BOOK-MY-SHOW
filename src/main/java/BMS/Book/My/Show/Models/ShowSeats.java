package BMS.Book.My.Show.Models;

import BMS.Book.My.Show.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="showseat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int rate;


    private String SeatNo;


    @Enumerated(value = EnumType.STRING)
    private SeatType seattype;


    private boolean booked;


    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Ticket ticket;

    @ManyToOne
    @JoinColumn
    private Show show;

}
