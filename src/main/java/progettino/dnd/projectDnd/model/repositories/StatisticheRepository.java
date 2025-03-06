package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.Statistiche;

import java.util.List;

@Repository
public interface StatisticheRepository extends JpaRepository<Statistiche, Long> {
    List<Statistiche> findByPgId(Long pgId);
}
