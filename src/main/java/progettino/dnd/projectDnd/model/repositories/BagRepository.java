package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.Bag;

import java.util.Optional;

@Repository
public interface BagRepository extends JpaRepository<Bag, Long> {
    Optional<Bag> findByPg_Id(Long pgId);
}
