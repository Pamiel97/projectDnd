package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.TalentDto;
import progettino.dnd.projectDnd.model.entities.Talent;


@Mapper(componentModel = "spring")
public interface TalentMapper {

    Talent toEntity(TalentDto talentDto);

    TalentDto toDto(Talent talent);
}
