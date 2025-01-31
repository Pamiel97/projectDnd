package progettino.dnd.projectDnd.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class DiaryDto {
    private long id;
    private String name;
    private String description;
    @JsonBackReference
    private long pgId; // ID del personaggio associato
    private List<MissionDto> missions; // Lista delle missioni associate

    public DiaryDto() {
    }

    public DiaryDto(long id, String name, String description, long pgId, List<MissionDto> missions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pgId = pgId;
        this.missions = missions;
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

    public long getPgId() {
        return pgId;
    }

    public void setPgId(long pgId) {
        this.pgId = pgId;
    }

    public List<MissionDto> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionDto> missions) {
        this.missions = missions;
    }
}
