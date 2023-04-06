package BMS.Book.My.Show.Repository;

import BMS.Book.My.Show.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {


    //List<Show> findByNameAndCity(String name,String city);
}
