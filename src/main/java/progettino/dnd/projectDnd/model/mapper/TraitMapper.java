package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.TraitDto;
import progettino.dnd.projectDnd.model.entities.Trait;


@Mapper(componentModel = "spring")
public interface TraitMapper {

    Trait toEntity(TraitDto traitDto);

    TraitDto toDto(Trait trait);
}
