package progettino.dnd.projectDnd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.dtos.StaticDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Statistiche;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.StatisticheService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/static")
public class StatisticheController {

    private StatisticheService staticService;

    public StatisticheController(StatisticheService staticService) {
        this.staticService = staticService;
    }

    @PostMapping("/{characterId}")
    public ResponseEntity<?> createStatic(
            @PathVariable long characterId,
            @RequestBody StaticDto staticDto) {
        try {
            Statistiche newStatic = staticDto.toEntity();
            Statistiche statichine = staticService.createStaticPg(characterId, newStatic);

            return new ResponseEntity<>(staticDto, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Statistiche> updateStatic(@RequestParam long id, @RequestBody StaticDto statics) {
        Statistiche updatedStatic = null;
        try {
            Statistiche converted = statics.toEntity();
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

    @PatchMapping("/{id}")
    public ResponseEntity<StaticDto> updateStaticField(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        Statistiche update = staticService.updateStaticFields(id, updates);
        StaticDto dto = StaticDto.fromEntity(update);

        return ResponseEntity.ok(dto);
    }


}
