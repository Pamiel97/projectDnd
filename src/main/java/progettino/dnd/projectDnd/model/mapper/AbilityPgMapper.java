package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityService;


@Mapper(componentModel = "spring")
public interface AbilityPgMapper {


    @Mappings({
            @Mapping(target = "ability", source = "abilityId", qualifiedByName = "mapAbilityIdToAbility"),  // Utilizziamo il metodo personalizzato per mappare l'ID dell'abilità
            @Mapping(target = "pg", source = "characterPgDto")  // Mappa il CharacterPgDto all'entità CharacterPg
    })
    AbilityPg toEntity(AbilityPgDto abilityPgDto);

    // Metodo di mappatura per convertire da Entity a DTO
    AbilityPgDto toDto(AbilityPg abilityPg);

    // Metodo personalizzato per mappare long in Ability (mappatura manuale dell'ID)
    @Named("mapAbilityIdToAbility")
    default Ability mapAbilityIdToAbility(long abilityId) {
        // Aggiungi la logica per recuperare l'Ability dal servizio
        // Usa il servizio per recuperare l'abilità
        // Presumendo che tu abbia accesso al servizio AbilityService in qualche modo
        // Puoi recuperare l'abilità direttamente
        AbilityService abilityService = getAbilityService();
        return abilityService.findById(abilityId)
                .orElseThrow(() -> new EntityNotFoundException("Ability not found for ID: " + abilityId));
    }

    // Questo è un metodo che ti permette di ottenere il tuo service
    // Devi assicurarci di avere accesso al servizio di cui abbiamo bisogno
    AbilityService getAbilityService();

}
