package progettino.dnd.projectDnd.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.mapper.CharacterPGMapper;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@Validated
public class CharacterPgController {
    private CharacterPgService characterPgService;
    private CharacterPGMapper characterPgMapper;

    @Autowired
    public CharacterPgController(CharacterPgService characterPgService, CharacterPGMapper characterPgMapper) {
        this.characterPgService = characterPgService;
        this.characterPgMapper = characterPgMapper;
    }

    @PostMapping("/campaign/{campaignId}")
    public ResponseEntity<CharacterPgDto> createCharacter(
            @RequestBody CharacterPgDto characterPgDto,   // DTO del personaggio
            @PathVariable long campaignId,                // ID della campagna dal path
            @AuthenticationPrincipal User user            // Dati utente (autenticazione)
    ) {
        try {
            // Usa il mapper per convertire il DTO in entità
            CharacterPg characterPg = characterPgMapper.toEntity(characterPgDto);

            // Passa gli ID specifici come parametri nel metodo del servizio
            CharacterPg createdCharacter = characterPgService.createCharacterPg(characterPg, user.getId(), campaignId);

            // Restituisci una risposta con il personaggio creato, mappato di nuovo nel DTO
            return new ResponseEntity<>(characterPgMapper.toDTO(createdCharacter), HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            // Se un'entità non è trovata, restituisci un errore 400 BAD REQUEST
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
