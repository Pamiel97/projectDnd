package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "npc")
public class NPC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String description;
    private boolean death;
    private String race;
    private String classe;


    @ManyToOne
    @JoinColumn(name = "campaign_id") // Questo specifica che nome avrà nella colonna nella tabella
    private Campaign campaign;


    public NPC(){

    }
    public NPC(long id, String name, String surname, String description, boolean death, String race, String classe, Campaign campaign) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.death = death;
        this.race = race;
        this.classe = classe;
        this.campaign = campaign;
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

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
