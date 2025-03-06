package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.TiriSalvezzaDto;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.TiriSalvezzaPgService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tiriSalvezza")
public class TiriSalvezzaController {
    private TiriSalvezzaPgService tiriSalvezzaPgService;

    @Autowired
    public TiriSalvezzaController(TiriSalvezzaPgService tiriSalvezzaPgService) {
        this.tiriSalvezzaPgService = tiriSalvezzaPgService;
    }

    @PostMapping("/{characterId}")
    public ResponseEntity<?> createStatic(
            @PathVariable long characterId,
            @RequestBody TiriSalvezzaDto ts) {
        try {
            TiriSalvezza newTiri = ts.toEntity();
            TiriSalvezza tiretti = tiriSalvezzaPgService.createTiriSalvezza(characterId, newTiri);

            return new ResponseEntity<>(ts, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/character/{characterId}")
    public ResponseEntity<List<TiriSalvezzaDto>> getTiriSalvezzaByCharacter(@PathVariable Long characterId) {
        List<TiriSalvezzaDto> dtoList = tiriSalvezzaPgService.getTiriSalvezzaByCharacter(characterId);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TiriSalvezza> updateStatic(@RequestParam long id, @RequestBody TiriSalvezzaDto tsDto) {
        TiriSalvezza updated = null;
        try {
            TiriSalvezza converted = tsDto.toEntity();
            updated = tiriSalvezzaPgService.updatetiri(id, converted);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(updated);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<TiriSalvezzaDto> updateTiriSalvezzaField(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {


        TiriSalvezza updatedTiriSalvezza = tiriSalvezzaPgService.updateTiriSalvezzaField(id, updates);


        TiriSalvezzaDto dto = TiriSalvezzaDto.fromEntity(updatedTiriSalvezza);


        return ResponseEntity.ok(dto);
    }


}
