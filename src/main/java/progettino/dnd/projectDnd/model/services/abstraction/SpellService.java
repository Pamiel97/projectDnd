package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.SpellDto;
import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

public interface SpellService {
    Spell createSpell(long id,Spell spell) throws EntityNotFoundException;
    Spell createSpellAndAssignToSlot(Long slotId, SpellDto spellDto) throws EntityNotFoundException;
}
