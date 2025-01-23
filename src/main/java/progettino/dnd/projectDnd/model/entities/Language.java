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
    private List<CharacterPg> pgs;  // Lista di incantesimi nello slot
}
