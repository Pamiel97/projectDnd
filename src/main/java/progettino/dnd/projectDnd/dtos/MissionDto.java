package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Diary;
import progettino.dnd.projectDnd.model.entities.Mission;
import progettino.dnd.projectDnd.model.entities.NPC;

import java.util.ArrayList;
import java.util.List;

public class MissionDto {
    private long id;
    private String name;
    private String description;
    private boolean complete;
    private String difficulty;
    private long diaryId;  // ID del diario associato
    private List<Long> npcIds;  // Lista degli ID degli NPC associati

    public MissionDto() {
    }

    public MissionDto(long id, String name, String description, boolean complete, String difficulty, long diaryId, List<Long> npcIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
        this.difficulty = difficulty;
        this.diaryId = diaryId;
        this.npcIds = npcIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(long diaryId) {
        this.diaryId = diaryId;
    }

    public List<Long> getNpcIds() {
        return npcIds;
    }

    public void setNpcIds(List<Long> npcIds) {
        this.npcIds = npcIds;
    }

    public static Mission toEntity(MissionDto missionDto, Diary diary) {
        if (missionDto == null) {
            return null;
        }

        Mission mission = new Mission();
        mission.setId(missionDto.getId());
        mission.setName(missionDto.getName());
        mission.setDescription(missionDto.getDescription());
        mission.setComplete(missionDto.isComplete());
        mission.setDifficulty(missionDto.getDifficulty());

        // Impostiamo il diario, usando l'oggetto Diary passato
        mission.setDiary(diary);

        // Gestiamo la relazione Many-to-Many con NPC (lista di NPC)
        if (missionDto.getNpcIds() != null) {
            List<NPC> npcs = new ArrayList<>();
            for (Long npcId : missionDto.getNpcIds()) {
                NPC npc = new NPC(); // Assumiamo che tu abbia un modo per ottenere gli NPC tramite il loro ID
                npc.setId(npcId); // Impostiamo solo l'ID dell'NPC
                npcs.add(npc);
            }
            mission.setNpc(npcs);  // Impostiamo la lista di NPC nella missione
        }

        return mission;
    }

    public static MissionDto fromEntity(Mission mission) {
        if (mission == null) {
            return null;
        }

        MissionDto missionDto = new MissionDto();
        missionDto.setId(mission.getId());
        missionDto.setName(mission.getName());
        missionDto.setDescription(mission.getDescription());
        missionDto.setComplete(mission.isComplete());
        missionDto.setDifficulty(mission.getDifficulty());

        // Impostiamo l'ID del diario
        if (mission.getDiary() != null) {
            missionDto.setDiaryId(mission.getDiary().getId());
        }

        // Gestiamo la relazione Many-to-Many con NPC (lista di NPC)
        if (mission.getNpc() != null) {
            List<Long> npcIds = new ArrayList<>();
            for (NPC npc : mission.getNpc()) {
                npcIds.add(npc.getId());  // Aggiungiamo gli ID degli NPC alla lista
            }
            missionDto.setNpcIds(npcIds);  // Impostiamo la lista di ID degli NPC nel DTO
        }

        return missionDto;
    }


}
