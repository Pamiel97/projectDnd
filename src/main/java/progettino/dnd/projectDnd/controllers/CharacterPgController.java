package progettino.dnd.projectDnd.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.CampaignDto;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/characters")
@Validated
public class CharacterPgController {
//    private CharacterPgService characterPgService;
//
//
//    @Autowired
//    public CharacterPgController(CharacterPgService characterPgService) {
//        this.characterPgService = characterPgService;
//
//    }
//
//    @PostMapping("/campaign/{campaignId}")
//    public ResponseEntity<CharacterPgDto> createCharacter(
//            @RequestBody CharacterPgDto characterPgDto,
//            @PathVariable long campaignId,
//            @AuthenticationPrincipal User user
//    ) {
//        try {
//            // Usa il mapper per convertire il DTO in entità
//            CharacterPg characterPg = characterPgMapper.toEntity(characterPgDto);
//
//            // Passa gli ID specifici come parametri nel metodo del servizio
//            CharacterPg createdCharacter = characterPgService.createCharacterPg(characterPg, user.getId(), campaignId);
//
//            // Restituisci una risposta con il personaggio creato, mappato di nuovo nel DTO
//            return new ResponseEntity<>(characterPgMapper.toDTO(createdCharacter), HttpStatus.CREATED);
//        } catch (EntityNotFoundException e) {
//            // Log dell'errore per capire meglio la causa
//            System.err.println("Entity not found exception: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        } catch (Exception e) {
//            // Gestione generale delle eccezioni
//            System.err.println("Unexpected error: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//
//
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllCharacter() {
//            List<CharacterPg> c = characterPgService.getAllCharacterPgs();
//
//            List<CharacterPgDto> cDto = c.stream()
//                    .map(characterPgMapper::toDTO)
//                    .collect(Collectors.toList());
//            return ResponseEntity.ok(cDto);
//    }


}
