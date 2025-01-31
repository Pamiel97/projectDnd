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
import progettino.dnd.projectDnd.model.mapper.AbilityPgMapper;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityPgService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/abilityPg")
@RestController
public class AbilityPgController {

    private AbilityPgService abilityPgService;

    private  AbilityPgMapper abilityPgMapper;


    @Autowired
    public AbilityPgController(AbilityPgMapper abilityPgMapper, AbilityPgService abilityPgService) {
        this.abilityPgMapper = abilityPgMapper;
        this.abilityPgService = abilityPgService;
    }


    @GetMapping("/all2")
    public ResponseEntity<?> getAllCharacter2() {
        List<AbilityPg> c = abilityPgService.getAll();

        // Usa l'istanza di AbilityPgMapper per chiamare toDto
        List<AbilityPgDto> cDto = c.stream()
                .map(abilityPg -> abilityPgMapper.toDto(abilityPg))
                .collect(Collectors.toList());

        return ResponseEntity.ok(cDto);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllCharacter() {
        List<AbilityPg> c = abilityPgService.getAll();
        return ResponseEntity.ok(c);
    }

}
