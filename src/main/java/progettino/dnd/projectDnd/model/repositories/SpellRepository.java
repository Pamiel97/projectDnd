package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.Spell;

import java.util.List;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {
    List<Spell> findDistinctBySlotsPgId(Long characterId);
}
