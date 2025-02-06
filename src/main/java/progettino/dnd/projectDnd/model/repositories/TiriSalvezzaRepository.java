package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;

import java.util.List;

@Repository
public interface TiriSalvezzaRepository extends JpaRepository<TiriSalvezza, Long> {
    List<TiriSalvezza> findByPgId(Long pgId);
}
