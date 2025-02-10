package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Mission;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface MissionService {
    Mission createMission(Mission mission, long diaryId) throws EntityNotFoundException;
    Mission linkNPCsToMission(long missionId, List<Long> npcIds);
    Mission updateMission(long id, Mission missionData) throws EntityNotFoundException;
}
