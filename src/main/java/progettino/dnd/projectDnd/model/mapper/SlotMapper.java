package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.SlotDto;
import progettino.dnd.projectDnd.model.entities.Slot;


@Mapper(componentModel = "spring")
public interface SlotMapper {

    Slot toEntity(SlotDto slotDto);

    SlotDto toDto(Slot slot);
}
