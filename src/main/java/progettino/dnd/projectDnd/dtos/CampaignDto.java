package progettino.dnd.projectDnd.dtos;

import jakarta.persistence.*;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.NPC;

import java.util.List;
import java.util.stream.Collectors;

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

    public static CampaignDto fromEntity(Campaign campaign) {
        if (campaign == null) {
            return null;
        }

        CampaignDto dto = new CampaignDto();
        dto.setId(campaign.getId());
        dto.setName(campaign.getName());
        dto.setDescription(campaign.getDescription());
        dto.setCharacterPgs(campaign.getCharacterPgs().stream().map(CharacterPgDto::fromEntity).collect(Collectors.toList()));
        dto.setNpcs(campaign.getNpcs().stream().map(NPCDto::fromEntity).collect(Collectors.toList()));

        return dto;
    }

    // Convert from DTO to Entity
    public Campaign toEntity() {
        Campaign campaign = new Campaign();
        campaign.setId(this.id);
        campaign.setName(this.name);
        campaign.setDescription(this.description);

        return campaign;
    }
}
