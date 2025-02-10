package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettino.dnd.projectDnd.dtos.SpellDto;
import progettino.dnd.projectDnd.model.entities.Slot;
import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.SlotRepository;
import progettino.dnd.projectDnd.model.repositories.SpellRepository;
import progettino.dnd.projectDnd.model.services.abstraction.SpellService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    @Override
    public Spell createSpellAndAssignToSlot(Long slotId, SpellDto spellDto) throws EntityNotFoundException {
        Optional<Slot> slotOptional = slotRepository.findById(slotId);
        if (slotOptional.isEmpty()) {
            throw new EntityNotFoundException("Slot not found with ID: " + slotId);
        }

        Slot slot = slotOptional.get();
        Spell spell = spellDto.toEntity();

        // Salviamo prima lo spell per ottenere l'ID
        spell = spellRepository.save(spell);

        // Creiamo la relazione ManyToMany
        slot.getSpells().add(spell);
        spell.getSlots().add(slot);

        // Salviamo nuovamente lo slot per aggiornare la relazione
        slotRepository.save(slot);

        return spell;
    }

    @Override
    public List<SpellDto> getSpellsByCharacter(Long characterId) {
        List<Spell> spells = spellRepository.findDistinctBySlotsPgId(characterId);
        return spells.stream()
                .map(SpellDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteSpell(Long id) {
        if (!spellRepository.existsById(id)) {
            throw new RuntimeException("Spell with ID " + id + " not found.");
        }
        spellRepository.deleteById(id);
    }
}
