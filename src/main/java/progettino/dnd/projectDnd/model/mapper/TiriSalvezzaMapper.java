package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.TiriSalvezzaDto;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;


@Mapper(componentModel = "spring")
public interface TiriSalvezzaMapper {

    TiriSalvezza toEntity(TiriSalvezzaDto tiriSalvezzaDto);

    TiriSalvezzaDto toDto(TiriSalvezza tiriSalvezza);
}
