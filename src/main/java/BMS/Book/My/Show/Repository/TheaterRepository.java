package BMS.Book.My.Show.Repository;

import BMS.Book.My.Show.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    Theater findByName(String name);
}
