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


    public Mission() {
    }

    public Mission(long id, String name, String description, boolean complete, String difficulty, Diary diary, List<NPC> npc) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
        this.difficulty = difficulty;
        this.diary = diary;
        this.npc = npc;
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

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public List<NPC> getNpc() {
        return npc;
    }

    public void setNpc(List<NPC> npc) {
        this.npc = npc;
    }
}
