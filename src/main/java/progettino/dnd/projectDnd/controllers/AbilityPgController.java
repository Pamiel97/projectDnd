package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.entities.CharacterPg;

import progettino.dnd.projectDnd.model.services.abstraction.AbilityPgService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/abilityPg")
@RestController
public class AbilityPgController {

    private AbilityPgService abilityPgService;

    public AbilityPgController(AbilityPgService abilityPgService){
        this.abilityPgService = abilityPgService;
    }


    @PostMapping("/all/ability/{characterId}")
    public ResponseEntity<?> createMultipleAbilityPgs(
            @RequestBody List<AbilityPgDto> abilityPgs,
            @PathVariable long characterId) {
        List<AbilityPg> listina = abilityPgs.stream().map(abilityPg -> abilityPg.toEntity()).toList();
        List<AbilityPg> createdAbilityPgs = abilityPgService.createMultipleAbilityPgs(listina, characterId);
        return ResponseEntity.status(HttpStatus.CREATED).body(abilityPgs);
    }


    @PostMapping("/single/{abilityId}/character/{characterId}")
    public ResponseEntity<AbilityPg> createAbilityPg(
            @RequestBody AbilityPgDto abilityPgDto,
            @PathVariable long abilityId,
            @PathVariable long characterId) {

        // Chiamata al service per creare AbilityPg
        AbilityPg abilityPg = abilityPgDto.toEntity();
        AbilityPg createdAbilityPg = abilityPgService.createAbilityPg(abilityPg, abilityId, characterId);

        // Restituisce una risposta con stato CREATED (201) e l'oggetto AbilityPg creato
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAbilityPg);
    }

}
