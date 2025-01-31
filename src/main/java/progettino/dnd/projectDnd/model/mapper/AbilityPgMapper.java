package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.AbilityPg;


@Mapper(componentModel = "spring")
public interface AbilityPgMapper {
    @Mapping(source = "ability", target = "abilityDto")
    AbilityPgDto toDto(AbilityPg abilityPg);

    @Mapping(source = "abilityDto", target = "ability")
    AbilityPg toEntity(AbilityPgDto abilityPgDto);
}
