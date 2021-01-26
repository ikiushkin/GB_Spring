package security.demo.repositories;

import security.demo.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import security.demo.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
}
