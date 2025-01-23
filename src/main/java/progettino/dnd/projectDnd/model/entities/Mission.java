package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "missions")
public class Mission {
    //se pensiamo a diversi giocatori questi hanno diversi pg molti a molti
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private boolean complete;
    private String difficulty;


    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary; //MOLTI A MOLTI?


    @ManyToMany
    @JoinTable(
            name = "npc_missions",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "npc_id")
    )
    private List<NPC> npc;

}
