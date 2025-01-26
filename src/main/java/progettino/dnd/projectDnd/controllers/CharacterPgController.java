package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;

@RestController
@RequestMapping("api/characters")
public class CharacterPgController {

    private final CharacterPgService characterPgService;

    @Autowired
    public CharacterPgController(CharacterPgService characterPgService) {
        this.characterPgService = characterPgService;
    }

    @PostMapping
    public ResponseEntity<CharacterPgDto> createCharacterPg(
            @Valid @RequestBody CharacterPgDto characterPgDto
    ) {
        CharacterPgDto createdCharacterPg = characterPgService.createCharacterPg(characterPgDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCharacterPg);
    }

    @GetMapping
    public ResponseEntity<List<CharacterPgDto>> getAllCharacterPgs() {
        List<CharacterPgDto> characters = characterPgService.getAllCharacterPgs();
        return ResponseEntity.ok(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterPgDto> getCharacterPgById(@PathVariable Long id) {
        CharacterPgDto characterPg = characterPgService.getCharacterPgById(id);
        return ResponseEntity.ok(characterPg);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterPgDto> updateCharacterPg(
            @PathVariable Long id,
            @Valid @RequestBody CharacterPgDto characterPgDto
    ) {
        CharacterPgDto updatedCharacterPg = characterPgService.updateCharacterPg(id, characterPgDto);
        return ResponseEntity.ok(updatedCharacterPg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacterPg(@PathVariable Long id) {
        characterPgService.deleteCharacterPg(id);
        return ResponseEntity.noContent().build();
    }
}
