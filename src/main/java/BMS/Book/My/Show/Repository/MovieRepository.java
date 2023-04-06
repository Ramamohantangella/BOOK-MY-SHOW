package BMS.Book.My.Show.Repository;

import BMS.Book.My.Show.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByName(String name);
    //Movie findByMoviename(String moviename);

    //Movie findByIdAndName(int id, String name);

    //void deleteByIdAndName(int id, String name);

    //Movie findByMovieName(String movieName);
}
