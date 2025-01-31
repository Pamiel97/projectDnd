package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.mapper.AbilityPgMapper;
import progettino.dnd.projectDnd.model.repositories.AbilityPgRepository;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityPgService;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityService;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;

@Service
public class AbilityPgJpa implements AbilityPgService {
    private AbilityPgMapper abilityPgMapper;
    private AbilityService abilityService;
    private AbilityPgRepository abilityPgRepository;


    @Autowired
    public AbilityPgJpa(AbilityPgMapper abilityPgMapper, AbilityService abilityService, AbilityPgRepository abilityPgRepository) {
        this.abilityPgMapper = abilityPgMapper;
        this.abilityService = abilityService;
        this.abilityPgRepository = abilityPgRepository;
    }






    @Autowired
    private CharacterPgRepository characterPgService;  // Servizio per recuperare CharacterPg

    // Recupera tutte le AbilityPg e carica le relazioni
    public List<AbilityPg> getAll() {
        List<AbilityPg> abilityPgs = abilityPgRepository.findAll();

        // Carica manualmente la relazione "ability" e "pg"
        for (AbilityPg abilityPg : abilityPgs) {
            // Assicurati che l'abilità e il personaggio siano caricati se non sono già presenti
            if (abilityPg.getAbility() == null) {
                abilityPg.setAbility(abilityService.findById(abilityPg.getAbility().getId()).orElse(null));
            }
            if (abilityPg.getPg() == null) {
                abilityPg.setPg(characterPgService.findById(abilityPg.getPg().getId()).orElse(null));
            }
        }
        return abilityPgs;
    }






    @Override
    public AbilityPg toEntity(AbilityPgDto abilityPgDto) {
        if (abilityPgDto.getAbilityId() <= 0) {
            throw new IllegalArgumentException("Invalid Ability ID");
        }
        if (abilityPgDto.getPgId() <= 0) {
            throw new IllegalArgumentException("Invalid CharacterPg ID");
        }

        try {
            Ability ability = abilityService.findById(abilityPgDto.getAbilityId())
                    .orElseThrow(() -> new EntityNotFoundException("Ability not found for ID: " + abilityPgDto.getAbilityId()));

            CharacterPg pg = characterPgService.findById(abilityPgDto.getPgId())
                    .orElseThrow(() -> new EntityNotFoundException("CharacterPg not found for ID: " + abilityPgDto.getPgId()));

            AbilityPg abilityPg = new AbilityPg();
            abilityPg.setId(abilityPgDto.getId());
            abilityPg.setCompetence(abilityPgDto.isCompetence());
            abilityPg.setPoint(abilityPgDto.getPoint());
            abilityPg.setAbility(ability);
            abilityPg.setPg(pg);

            return abilityPg;

        } catch (EntityNotFoundException e) {
            // Log dell'errore e rilancio come IllegalArgumentException
            throw new IllegalArgumentException("Invalid data: " + e.getMessage(), e);
        }
    }

    @Override
    public AbilityPgDto toDto(AbilityPg abilityPg) {
        // Mappa l'entità AbilityPg al DTO
        return abilityPgMapper.toDto(abilityPg);
    }




//    @Override
//    public List<AbilityPg> getAll() {
//        return abilityPgRepository.findAll();
//    }
}
