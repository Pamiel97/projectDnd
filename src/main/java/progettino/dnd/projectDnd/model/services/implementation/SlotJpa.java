package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Slot;
import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.SlotRepository;
import progettino.dnd.projectDnd.model.repositories.SpellRepository;
import progettino.dnd.projectDnd.model.services.abstraction.SlotService;

import java.util.List;

@Service
public class SlotJpa implements SlotService {

    private SlotRepository slotRepository;
    private SpellRepository spellRepository;
    private CharacterPgRepository characterPgRepository;

    public SlotJpa(SlotRepository slotRepository, SpellRepository spellRepository, CharacterPgRepository characterPgRepository) {
        this.slotRepository = slotRepository;
        this.spellRepository = spellRepository;
        this.characterPgRepository = characterPgRepository;
    }



    @Override
    public Slot createSlot(Slot slot, long id) throws EntityNotFoundException {
        CharacterPg character = characterPgRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CharacterPg not found with id: " + id));

        slot.setPg(character);

        // Verifica e associa gli Spell (se presenti)
        if (slot.getSpells() != null && !slot.getSpells().isEmpty()) {
            List<Long> spellIds = slot.getSpells().stream().map(Spell::getId).toList();
            List<Spell> spells = spellRepository.findAllById(spellIds);
            slot.setSpells(spells);
        }
        return slotRepository.save(slot);
    }
}
