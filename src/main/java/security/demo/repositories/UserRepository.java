package security.demo.repositories;
import security.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import security.demo.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
