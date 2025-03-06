package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.AbilityPg;

import java.util.List;

@Repository
public interface AbilityPgRepository extends JpaRepository<AbilityPg, Long> {
   // AbilityPg findById(long id);
    List<AbilityPg> findByPgId(Long pgId);
}
