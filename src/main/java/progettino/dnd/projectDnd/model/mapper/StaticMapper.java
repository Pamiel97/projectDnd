package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.StaticDto;
import progettino.dnd.projectDnd.model.entities.Static;

@Mapper(componentModel = "spring")
public interface StaticMapper {

    Static toEntity(StaticDto staticDto);

    StaticDto toDto(Static statc);
}
