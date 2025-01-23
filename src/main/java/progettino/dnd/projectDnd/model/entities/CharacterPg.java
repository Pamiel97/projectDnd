package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "characters_pg")
public class CharacterPg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String classe;
    private String race;
    private int level;
    private String background;
    private String allignment;
    private int exp;
    @Column(name = "physical_trait")
    private String physicalTrait;
    private int ispiration;
    @Column(name = "bonus_competence")
    private int bonusCompetence;
    private int perception;
    private int ca;
    private int iniziative;
    private int speed;
    @Column(name = "total_hp")
    private int totalHp;
    @Column(name = "actual_hp")
    private int actualHp;
    @Column(name = "temporany_hp")
    private int temporanyHp;
    private int dice;
    @Column(name = "dice_health")
    private int diceHealth;
    private String caratterial;
    private String ideals;
    private String note;
    private int money;
    private String img;



    @ManyToOne
    @JoinColumn(name = "user_id") // Questo specifica che nome avrà nella colonna nella tabella
    private User user;

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Slot> slots;  // Lista di slot associati al PG

    @OneToOne(mappedBy = "pg")
    private Bag bag;

    @OneToOne(mappedBy = "pg")
    private Diary diary;

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AbilityPg> abilityPgs;

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Static> staticList;

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TiriSalvezza> tiriSalvezza;

    @ManyToOne
    @JoinColumn(name = "campaign_id") // Questo specifica che nome avrà nella colonna nella tabella
    private Campaign campaign;

    @ManyToMany
    @JoinTable(
            name = "talents_pgs",
            joinColumns = @JoinColumn(name = "pg_id"),
            inverseJoinColumns = @JoinColumn(name = "talent_id")
    )
    private List<Talent> talents;


    @ManyToMany
    @JoinTable(
            name = "traits_pgs",
            joinColumns = @JoinColumn(name = "pg_id"),
            inverseJoinColumns = @JoinColumn(name = "trait_id")
    )
    private List<Trait> traits;

}
