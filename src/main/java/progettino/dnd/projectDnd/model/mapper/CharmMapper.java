package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.CharmDto;
import progettino.dnd.projectDnd.model.entities.Charm;


@Mapper(componentModel = "spring")
public interface CharmMapper {

    Charm toEntity(CharmDto charmDto);

    CharmDto toDto(Charm charm);
}
