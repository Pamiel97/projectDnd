package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Diary;
import progettino.dnd.projectDnd.model.entities.Mission;
import progettino.dnd.projectDnd.model.entities.NPC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissionDto {
    private long id;
    private String name;
    private String description;
    private boolean complete;
    private String difficulty;
    private long diaryId;  // ID del diario associato
    private List<NPCDto> npcs;  // Lista degli ID degli NPC associati

    public MissionDto() {
    }


    public MissionDto(long id, String name, String description, boolean complete, String difficulty, long diaryId, List<NPCDto> npcs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
        this.difficulty = difficulty;
        this.diaryId = diaryId;
        this.npcs = npcs;
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

    public List<NPCDto> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPCDto> npcs) {
        this.npcs = npcs;
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
        missionDto.setNpcs(mission.getNpc() != null ? mission.getNpc().stream().map(NPCDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());

        return missionDto;
    }





    public Mission toEntity() {
        Mission mission = new Mission();
        mission.setId(this.id);
        mission.setName(this.name);
        mission.setDescription(this.description);
        mission.setComplete(this.complete);
        mission.setDifficulty(this.difficulty);
        mission.setNpc(this.npcs != null ? this.npcs.stream().map(npcDto -> npcDto.toEntity()).collect(Collectors.toList()) : new ArrayList<>());
        return mission;
    }


}
