package progettino.dnd.projectDnd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.SpellDto;
import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.SpellService;

@RestController
@RequestMapping("/spells")
public class SpellController {

    private SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @PostMapping("/{slotId}")
    public ResponseEntity<SpellDto> createSpell(
            @PathVariable long slotId,
            @RequestBody SpellDto spellDto) {
        try {
            Spell newSpell = spellDto.toEntity();
            Spell spell = spellService.createSpell(slotId, newSpell);
            return new ResponseEntity<>(spellDto, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
