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
    @Mapping(target = "ability.id", source = "abilityId")
//    @Mapping(target = "pg", source = "characterPgDto")
    AbilityPg toEntity(AbilityPgDto abilityPgDto);

    @Mapping(source = "ability.id", target = "abilityId")
    @Mapping(source = "pg.id", target = "characterPgDto.id")
    AbilityPgDto toDto(AbilityPg abilityPg);
}
