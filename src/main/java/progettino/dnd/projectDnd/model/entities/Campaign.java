package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "campaignes")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CharacterPg> characterPgs;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
    List<NPC> npcs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
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

    public List<CharacterPg> getCharacterPgs() {
        return characterPgs;
    }

    public void setCharacterPgs(List<CharacterPg> characterPgs) {
        this.characterPgs = characterPgs;
    }
}
