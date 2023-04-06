package BMS.Book.My.Show.Models;


import BMS.Book.My.Show.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theaterseats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;


    private int rate;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}
