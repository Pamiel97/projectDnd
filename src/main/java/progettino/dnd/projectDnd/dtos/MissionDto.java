package progettino.dnd.projectDnd.dtos;

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
}
