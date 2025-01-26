package progettino.dnd.projectDnd.dtos;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CharacterPgDto {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Size(max = 50, message = "Surname must be max 50 characters")
    private String surname;

    @NotBlank(message = "Class cannot be blank")
    private String classe;

    @NotBlank(message = "Race cannot be blank")
    private String race;

    @Min(value = 1, message = "Level must be at least 1")
    @Max(value = 20, message = "Level cannot exceed 20")
    private int level;

    private String background;
    private String allignment;

    @Min(value = 0, message = "Experience cannot be negative")
    private int exp;
    private String physicalTrait;
    private int ispiration;
    private int bonusCompetence;
    private int perception;
    private int ca;
    private int iniziative;
    private int speed;

    @Min(value = 1, message = "Total HP must be at least 1")
    private int totalHp;

    private int actualHp;
    private int temporanyHp;
    private int dice;
    private int diceHealth;
    private String caratterial;
    private String ideals;
    private String note;
    private int money;
    private String img;
    private Long userId;
    private Long campaignId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }
}
