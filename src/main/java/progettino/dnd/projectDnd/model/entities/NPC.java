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

}
