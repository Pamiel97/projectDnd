package progettino.dnd.projectDnd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.entities.CharacterPg;

@RequestMapping("/api/abilityPg")
@RestController
public class AbilityPgController {




//    @PostMapping("/ability-pgs")
//    public ResponseEntity<AbilityPgDto> createAbilityPg(@RequestBody AbilityPgDto abilityPgDto) {
//        try {
//            // Carica l'abilità dal database usando l'ID fornito nel DTO
//            Ability ability = abilityService.findById(abilityPgDto.getAbilityDto().getId());
//            if (ability == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Notifica se l'abilità non è trovata
//            }
//
//            // Carica il PG dal database usando l'ID del PG
//            CharacterPg pg = characterPgService.findById(abilityPgDto.getCharacterPgDto().getId());
//            if (pg == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Notifica se il PG non è trovato
//            }
//
//            // Crea l'oggetto AbilityPg utilizzando l'abilità e il PG recuperati
//            AbilityPg abilityPg = new AbilityPg();
//            abilityPg.setCompetence(abilityPgDto.isCompetence());
//            abilityPg.setPoint(abilityPgDto.getPoint());
//            abilityPg.setAbility(ability);  // Associa l'abilità trovata
//            abilityPg.setPg(pg);            // Associa il PG trovato
//
//            // Salva l'AbilityPg
//            AbilityPg savedAbilityPg = abilityPgService.saveAbilityPg(abilityPg);
//
//            // Restituisci la risposta con l'AbilityPg creato
//            return ResponseEntity.ok(abilityPgDto);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
}
