package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "lenguages_pgs",
            joinColumns = @JoinColumn(name = "lenguage_id"),
            inverseJoinColumns = @JoinColumn(name = "pg_id")
    )
    private List<CharacterPg> pgs;


    public Language() {
    }

    public Language(long id, String name, List<CharacterPg> pgs) {
        this.id = id;
        this.name = name;
        this.pgs = pgs;
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

    public List<CharacterPg> getPgs() {
        return pgs;
    }

    public void setPgs(List<CharacterPg> pgs) {
        this.pgs = pgs;
    }
}
