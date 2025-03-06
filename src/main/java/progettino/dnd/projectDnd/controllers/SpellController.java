package progettino.dnd.projectDnd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.SpellDto;
import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.SlotService;
import progettino.dnd.projectDnd.model.services.abstraction.SpellService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/spells")
public class SpellController {

    private SpellService spellService;
    private SlotService slotService;

    public SpellController(SpellService spellService, SlotService slotService) {
        this.spellService = spellService;
        this.slotService = slotService;
    }


    @GetMapping("/character/{characterId}")
    public ResponseEntity<List<SpellDto>> getSpellsByCharacter(@PathVariable Long characterId) {
        List<SpellDto> spellDtos = spellService.getSpellsByCharacter(characterId);
        return new ResponseEntity<>(spellDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpell(@PathVariable Long id) {
        spellService.deleteSpell(id);
        return ResponseEntity.ok("Spell with ID " + id + " deleted successfully.");
    }

    @GetMapping("/{slotId}/spells")
    public ResponseEntity<List<SpellDto>> getSpellsBySlot(@PathVariable Long slotId) {
        List<SpellDto> spells = slotService.getSpellsBySlot(slotId);
        return new ResponseEntity<>(spells, HttpStatus.OK);
    }


    @PostMapping("/create-and-assign/{slotId}")
    public ResponseEntity<SpellDto> createAndAssignSpell(
            @PathVariable Long slotId,
            @RequestBody SpellDto spellDto) {
        try {
            Spell createdSpell = spellService.createSpellAndAssignToSlot(slotId, spellDto);
            return new ResponseEntity<>(spellDto, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PatchMapping("/{spellId}")
//    public ResponseEntity<SpellDto> updateSpell(
//            @PathVariable Long spellId,
//            @RequestBody SpellDto spellDto) {
//        try {
//            Spell updatedSpell = spellService.updateSpell(spellId, spellDto);
//            return new ResponseEntity<>(new SpellDto(updatedSpell), HttpStatus.OK);
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


}
