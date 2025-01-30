package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.PotionDto;
import progettino.dnd.projectDnd.model.entities.Potion;


@Mapper(componentModel = "spring")
public interface PotionMapper {

    Potion toEntity(PotionDto potionDto);

    PotionDto toDto(Potion potion);
}
