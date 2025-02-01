package progettino.dnd.projectDnd.dtos;

import jakarta.persistence.*;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.NPC;

public class NPCDto {

    private long id;
    private String name;
    private String surname;
    private String description;
    private boolean death;
    private String race;
    private String classe;
    private long campaignId;



    public NPCDto(){

    }
    public NPCDto(long id, String name, String surname, String description, boolean death, String race, String classe, long campaignId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.death = death;
        this.race = race;
        this.classe = classe;
        this.campaignId = campaignId;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }


    public static NPCDto fromEntity(NPC npc) {
        if (npc == null) {
            return null;
        }

        NPCDto npcDto = new NPCDto();
        npcDto.setId(npc.getId());
        npcDto.setName(npc.getName());
        npcDto.setSurname(npc.getSurname());
        npcDto.setDescription(npc.getDescription());
        npcDto.setDeath(npc.isDeath());
        npcDto.setRace(npc.getRace());
        npcDto.setClasse(npc.getClasse());

        // Impostiamo l'ID della campagna
        if (npc.getCampaign() != null) {
            npcDto.setCampaignId(npc.getCampaign().getId());
        }

        return npcDto;
    }




    //TODO
    public NPC toEntity() {

        NPC npc = new NPC();
        npc.setId(this.id);
        npc.setName(this.name);
        npc.setSurname(this.surname);
        npc.setDescription(this.description);
        npc.setDeath(this.death);
        npc.setRace(this.race);
        npc.setClasse(this.classe);

        //CAMPAGNA DA SETTARE con id hehe

        return npc;
    }


}
