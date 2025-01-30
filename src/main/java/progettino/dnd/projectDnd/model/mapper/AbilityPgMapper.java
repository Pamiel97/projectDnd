package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;

import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.AbilityPg;


@Mapper(componentModel = "spring")
public interface AbilityPgMapper {

    AbilityPg toEntity(AbilityPgDto abilityPgDto);

    AbilityPgDto toDto(AbilityPg abilityPg);
}
