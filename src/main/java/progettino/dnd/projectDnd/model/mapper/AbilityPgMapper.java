package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import progettino.dnd.projectDnd.dtos.AbilityDto;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityService;


@Mapper(componentModel = "spring")
public interface AbilityPgMapper {

    @Mappings({
            @Mapping(target = "abilityId", source = "ability.id"),
            @Mapping(target = "pgId", source = "pg.id")
    })
    AbilityPgDto toDto(AbilityPg abilityPg);

    @Mappings({
            @Mapping(target = "ability", ignore = true),  // Ignoriamo, sarà impostato manualmente
            @Mapping(target = "pg", ignore = true)        // Stessa cosa per il pg
    })
    AbilityPg toEntity(AbilityPgDto abilityPgDto);
}
