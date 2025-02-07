package progettino.dnd.projectDnd.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
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



    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id") // Questo specifica che nome avrà nella colonna nella tabella
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL)
    private List<Slot> slots;  // Lista di slot associati al PG

    @JsonIgnore
    @JsonBackReference
    @OneToOne(mappedBy = "pg", fetch = FetchType.LAZY)
    private Bag bag;

    @JsonIgnore
    @JsonBackReference
    @OneToOne(mappedBy = "pg", fetch = FetchType.LAZY)
    private Diary diary;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL)
    private List<AbilityPg> abilityPgs = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL)
    private List<Static> staticList;

    @JsonIgnore
    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL)
    private List<TiriSalvezza> tiriSalvezza;

    @JsonIgnore
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getAllignment() {
        return allignment;
    }

    public void setAllignment(String allignment) {
        this.allignment = allignment;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getPhysicalTrait() {
        return physicalTrait;
    }

    public void setPhysicalTrait(String physicalTrait) {
        this.physicalTrait = physicalTrait;
    }

    public int getIspiration() {
        return ispiration;
    }

    public void setIspiration(int ispiration) {
        this.ispiration = ispiration;
    }

    public int getBonusCompetence() {
        return bonusCompetence;
    }

    public void setBonusCompetence(int bonusCompetence) {
        this.bonusCompetence = bonusCompetence;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getIniziative() {
        return iniziative;
    }

    public void setIniziative(int iniziative) {
        this.iniziative = iniziative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTotalHp() {
        return totalHp;
    }

    public void setTotalHp(int totalHp) {
        this.totalHp = totalHp;
    }

    public int getActualHp() {
        return actualHp;
    }

    public void setActualHp(int actualHp) {
        this.actualHp = actualHp;
    }

    public int getTemporanyHp() {
        return temporanyHp;
    }

    public void setTemporanyHp(int temporanyHp) {
        this.temporanyHp = temporanyHp;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getDiceHealth() {
        return diceHealth;
    }

    public void setDiceHealth(int diceHealth) {
        this.diceHealth = diceHealth;
    }

    public String getCaratterial() {
        return caratterial;
    }

    public void setCaratterial(String caratterial) {
        this.caratterial = caratterial;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public List<AbilityPg> getAbilityPgs() {
        return abilityPgs;
    }

    public void setAbilityPgs(List<AbilityPg> abilityPgs) {
        this.abilityPgs = abilityPgs;
    }

    public List<Static> getStaticList() {
        return staticList;
    }

    public void setStaticList(List<Static> staticList) {
        this.staticList = staticList;
    }

    public List<TiriSalvezza> getTiriSalvezza() {
        return tiriSalvezza;
    }

    public void setTiriSalvezza(List<TiriSalvezza> tiriSalvezza) {
        this.tiriSalvezza = tiriSalvezza;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public List<Talent> getTalents() {
        return talents;
    }

    public void setTalents(List<Talent> talents) {
        this.talents = talents;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }
}
