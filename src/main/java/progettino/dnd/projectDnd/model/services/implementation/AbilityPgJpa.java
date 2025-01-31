package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.mapper.AbilityPgMapper;
import progettino.dnd.projectDnd.model.repositories.AbilityPgRepository;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityPgService;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityService;

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

    public AbilityPg toEntity(AbilityPgDto abilityPgDto) throws EntityNotFoundException {
        // Recupera l'abilità dal servizio utilizzando l'ID
        Ability ability = abilityService.findById(abilityPgDto.getAbilityId())
                .orElseThrow(() -> new EntityNotFoundException("Ability not found for ID: " + abilityPgDto.getAbilityId()));

        // Mappa l'entity dal DTO (il metodo 'toEntity' mappa il resto dei campi)
        AbilityPg abilityPg = abilityPgMapper.toEntity(abilityPgDto);

        // Imposta manualmente l'abilità nel `AbilityPg`
        abilityPg.setAbility(ability);

        return abilityPg;
    }


    @Override
    public List<AbilityPg> getAll() {
        return abilityPgRepository.findAll();
    }
}
