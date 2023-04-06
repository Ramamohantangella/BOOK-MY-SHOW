package BMS.Book.My.Show.Repository;

import BMS.Book.My.Show.Models.TheaterSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatsRepository extends JpaRepository<TheaterSeats,Integer> {
}
