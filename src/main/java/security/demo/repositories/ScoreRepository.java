package security.demo.repositories;
import security.demo.entities.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import security.demo.entities.Score;

@Repository
public interface ScoreRepository  extends CrudRepository<Score,Long> {

}
