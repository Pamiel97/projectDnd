package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.AbilityDto;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;

@Mapper(componentModel = "spring")
public interface AbilityMapper {
    Ability toEntity(AbilityDto abilityDto);

    AbilityDto toDto(Ability ability);
}
