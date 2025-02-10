package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import progettino.dnd.projectDnd.model.repositories.AbilityPgRepository;
import progettino.dnd.projectDnd.model.repositories.AbilityRepository;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityPgService;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityService;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbilityPgJpa implements AbilityPgService {

    private AbilityRepository abilityRepository;
    private AbilityPgRepository abilityPgRepository;
    private CharacterPgRepository characterPgRepository;


    @Autowired
    public AbilityPgJpa( AbilityRepository abilityRepository, AbilityPgRepository abilityPgRepository, CharacterPgRepository characterPgRepository) {

        this.abilityRepository = abilityRepository;
        this.abilityPgRepository = abilityPgRepository;
        this.characterPgRepository = characterPgRepository;
    }


    //Questo va ma dobbiamo capire come farne più insieme in una sola volta
    @Override
    @Transactional
    public AbilityPg createAbilityPg(AbilityPg abilityPg, long abilityId, long characterId) {
        Ability ability = abilityRepository.findById(abilityId)
                .orElseThrow(() -> new IllegalArgumentException("Ability not found for ID: " + abilityId));

        CharacterPg characterPg = characterPgRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("CharacterPg not found for ID: " + characterId));

        abilityPg.setAbility(ability);
        abilityPg.setPg(characterPg);

        return abilityPgRepository.save(abilityPg);
    }


    //QUESTO NON FUNGE
    @Override
    @Transactional
    public List<AbilityPg> createMultipleAbilityPgs(List<AbilityPg> abilityPgs, long characterId) {
        CharacterPg characterPg = characterPgRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("CharacterPg not found for ID: " + characterId));

        for (AbilityPg abilityPg : abilityPgs) {
            Ability ability = abilityRepository.findById(abilityPg.getAbility().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Ability not found for ID: " + abilityPg.getAbility().getId()));

            abilityPg.setAbility(ability);
            abilityPg.setPg(characterPg);
        }

        return abilityPgRepository.saveAll(abilityPgs);
    }

    public List<AbilityPgDto> getAbilitiesPgByCharacter(Long pgId) {
        List<AbilityPg> abilityPgs = abilityPgRepository.findByPgId(pgId);
        return abilityPgs.stream()
                .map(AbilityPgDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    @Transactional
    public AbilityPg updateAbilityPg(long id, AbilityPg updatedAbilityPg) throws EntityNotFoundException{
        // Recupero dell'entità esistente


        AbilityPg existingAbilityPg = abilityPgRepository.findById(id);


        // Aggiornamento dei campi (controllando che siano valorizzati)
        if (updatedAbilityPg.getAbility() != null) {
            Ability ability = abilityRepository.findById(updatedAbilityPg.getAbility().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Ability not found for ID: " + updatedAbilityPg.getAbility().getId()));
            existingAbilityPg.setAbility(ability);
        }

        if (updatedAbilityPg.getPg() != null) {
            CharacterPg characterPg = characterPgRepository.findById(updatedAbilityPg.getPg().getId())
                    .orElseThrow(() -> new IllegalArgumentException("CharacterPg not found for ID: " + updatedAbilityPg.getPg().getId()));
            existingAbilityPg.setPg(characterPg);
        }

        // Aggiorna altri campi primitivi
        existingAbilityPg.setCompetence(updatedAbilityPg.isCompetence());
        existingAbilityPg.setPoint(updatedAbilityPg.getPoint());

        // Salvataggio nel repository
        return abilityPgRepository.save(existingAbilityPg);
    }


}
