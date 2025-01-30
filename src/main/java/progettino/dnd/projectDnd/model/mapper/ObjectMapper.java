package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.ObjectDto;
import progettino.dnd.projectDnd.model.entities.Object;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

    Object toEntity(ObjectDto objectDto);

    ObjectDto toDto(Object object);
}
