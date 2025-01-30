package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;

import progettino.dnd.projectDnd.dtos.BagDto;
import progettino.dnd.projectDnd.model.entities.Bag;

@Mapper(componentModel = "spring")
public interface BagMapper {

    Bag toEntity(BagDto bagDto);

    BagDto toDto(Bag bag);
}
