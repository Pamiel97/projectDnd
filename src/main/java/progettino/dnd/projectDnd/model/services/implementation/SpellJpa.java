package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.entities.Slot;
import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.SlotRepository;
import progettino.dnd.projectDnd.model.repositories.SpellRepository;
import progettino.dnd.projectDnd.model.services.abstraction.SpellService;

import java.util.Optional;

@Service
public class SpellJpa implements SpellService {
    private SpellRepository spellRepository;
    private SlotRepository slotRepository;

    @Autowired
    public SpellJpa(SpellRepository spellRepository, SlotRepository slotRepository) {
        this.spellRepository = spellRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public Spell createSpell(long slotId, Spell spell) throws EntityNotFoundException {
        // Recupera lo Slot dal database
        Slot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new EntityNotFoundException("Slot not found with id: " + slotId));

        // Salva l'incantesimo
        Spell savedSpell = spellRepository.save(spell);

        // Associa lo Spell allo Slot
        slot.getSpells().add(savedSpell);

        // Salva la relazione nel database
        slotRepository.save(slot);

        return savedSpell;
    }

}
