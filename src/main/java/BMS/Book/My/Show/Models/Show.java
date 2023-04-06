package BMS.Book.My.Show.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    private double multiplier;
    private LocalDate showDate;


    private LocalTime showTime;



    @OneToMany(mappedBy ="show",cascade = CascadeType.ALL)
    private List<ShowSeats> ShowSeatList;


    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> TicketList;

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @ManyToOne
    @JoinColumn
    private Theater theater;



}