package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.User;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<User, Long> {
    Optional<User> findById(long id);


}
