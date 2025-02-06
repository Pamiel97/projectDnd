package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.entities.*;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.DiaryRepository;
import progettino.dnd.projectDnd.model.repositories.MissionRepository;
import progettino.dnd.projectDnd.model.repositories.NPCRepository;
import progettino.dnd.projectDnd.model.services.abstraction.MissionService;

import java.util.List;
import java.util.Optional;

@Service
public class MissionJpa implements MissionService {
   private MissionRepository missionRepository;
   private DiaryRepository diaryRepository;
   private NPCRepository npcRepository;

    public MissionJpa(MissionRepository missionRepository, DiaryRepository diaryRepository, NPCRepository npcRepository) {
        this.missionRepository = missionRepository;
        this.diaryRepository = diaryRepository;
        this.npcRepository = npcRepository;
    }

    @Override
    public Mission createMission(Mission mission, long diaryId) throws EntityNotFoundException {
        Optional<Diary> diaryOptional = diaryRepository.findById(diaryId);
        if (diaryOptional.isPresent()) {
            Diary diary = diaryOptional.get();
            mission.setDiary(diary);
            return missionRepository.save(mission);
        } else {
            throw new EntityNotFoundException("Diario con id " + diaryId + " non trovato.");
        }
    }

    @Override
    public Mission linkNPCsToMission(long missionId, List<Long> npcIds) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission with ID " + missionId + " not found."));

        List<NPC> npcs = npcRepository.findAllById(npcIds);
        mission.getNpc().addAll(npcs);
        return missionRepository.save(mission);
    }



}
