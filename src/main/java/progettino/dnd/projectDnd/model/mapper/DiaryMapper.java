package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.DiaryDto;
import progettino.dnd.projectDnd.model.entities.Diary;


@Mapper(componentModel = "spring")
public interface DiaryMapper {

    Diary toEntity(DiaryDto diaryDto);

    DiaryDto toDto(Diary diary);
}
