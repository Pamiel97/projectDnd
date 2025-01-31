package progettino.dnd.projectDnd.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityService;

public class AbilityPgMapperDecorator implements AbilityPgMapper{
    private final AbilityPgMapper delegate;
    private final AbilityService abilityService;

    @Autowired
    public AbilityPgMapperDecorator(AbilityPgMapper delegate, AbilityService abilityService) {
        this.delegate = delegate;
        this.abilityService = abilityService;
    }

    @Override
    public AbilityPg toEntity(AbilityPgDto abilityPgDto) {
        // Usa il metodo del mapper delegato
        AbilityPg abilityPg = delegate.toEntity(abilityPgDto);

        // Recupera l'abilità dal servizio
        long abilityId = abilityPgDto.getAbilityId();
        Ability ability = abilityService.findById(abilityId)
                .orElseThrow(() -> new EntityNotFoundException("Ability not found for ID: " + abilityId));

        // Imposta l'abilità nel `AbilityPg`
        abilityPg.setAbility(ability);

        return abilityPg;
    }

    @Override
    public AbilityPgDto toDto(AbilityPg abilityPg) {
        return delegate.toDto(abilityPg);
    }

    @Override
    public AbilityService getAbilityService() {
        return abilityService;
    }
}
