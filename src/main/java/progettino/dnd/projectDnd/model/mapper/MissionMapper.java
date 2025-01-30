package progettino.dnd.projectDnd.model.mapper;


import progettino.dnd.projectDnd.dtos.MissionDto;
import progettino.dnd.projectDnd.model.entities.Mission;

public interface MissionMapper {

    Mission toEntity(MissionDto missionDto);

    MissionDto toDto(Mission mission);
}
