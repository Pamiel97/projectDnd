package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.EquipDto;
import progettino.dnd.projectDnd.model.entities.Equip;


@Mapper(componentModel = "spring")
public interface EquipMapper {

    Equip toEntity(EquipDto equipDto);

    EquipDto toDto(Equip equip);
}
