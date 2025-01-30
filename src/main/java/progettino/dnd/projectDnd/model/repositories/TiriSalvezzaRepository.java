package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;

@Repository
public interface TiriSalvezzaRepository extends JpaRepository<TiriSalvezza, Long> {
}
