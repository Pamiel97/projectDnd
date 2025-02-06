package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.Static;

import java.util.List;

@Repository
public interface StaticRepository extends JpaRepository<Static, Long> {
    List<Static> findByPgId(Long pgId);
}
