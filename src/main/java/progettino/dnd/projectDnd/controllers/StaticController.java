package progettino.dnd.projectDnd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.SpellDto;
import progettino.dnd.projectDnd.dtos.StaticDto;
import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.entities.Static;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.StaticService;

import java.util.List;

@RestController
@RequestMapping("/api/static")
public class StaticController {

    private StaticService staticService;

    public StaticController(StaticService staticService) {
        this.staticService = staticService;
    }

    @PostMapping("/{characterId}")
    public ResponseEntity<?> createStatic(
            @PathVariable long characterId,
            @RequestBody StaticDto staticDto) {
        try {
            Static newStatic = staticDto.toEntity();
            Static statichine = staticService.createStaticPg(characterId, newStatic);

            return new ResponseEntity<>(staticDto, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Static> updateStatic(@RequestParam long id, @RequestBody StaticDto statics) {
        Static updatedStatic = null;
        try {
            Static converted = statics.toEntity();
            updatedStatic = staticService.updateStatic(id, converted);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(updatedStatic);
    }

    @GetMapping("/character/{characterId}")
    public ResponseEntity<List<StaticDto>> getStaticsByCharacter(@PathVariable Long characterId) {
        List<StaticDto> staticDtos = staticService.getStaticsByCharacter(characterId);
        return new ResponseEntity<>(staticDtos, HttpStatus.OK);
    }
}
