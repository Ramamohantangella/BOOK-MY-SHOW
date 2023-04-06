package BMS.Book.My.Show.Repository;

import BMS.Book.My.Show.Models.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeats,Integer> {
}
