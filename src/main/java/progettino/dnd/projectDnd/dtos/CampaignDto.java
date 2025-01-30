package progettino.dnd.projectDnd.dtos;

import jakarta.persistence.*;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.NPC;

import java.util.List;

public class CampaignDto {

    private long id;
    private String name;
    private String description;
    List<CharacterPgDto> characterPgs;
    List<NPCDto> npcs;


    public CampaignDto() {

    }

    public CampaignDto(long id, String name, String description, List<CharacterPgDto> characterPgs, List<NPCDto> npcs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.characterPgs = characterPgs;
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

    public List<CharacterPgDto> getCharacterPgs() {
        return characterPgs;
    }

    public void setCharacterPgs(List<CharacterPgDto> characterPgs) {
        this.characterPgs = characterPgs;
    }

    public List<NPCDto> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPCDto> npcs) {
        this.npcs = npcs;
    }
}
