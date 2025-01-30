package progettino.dnd.projectDnd.dtos;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CharacterPgDto {

    private long id;
    private String name;
    private String surname;
    private String classe;
    private String race;
    private int level;
    private String background;
    private String allignment;
    private int exp;
    private String physicalTrait;
    private int ispiration;
    private int bonusCompetence;
    private int perception;
    private int ca;
    private int iniziative;
    private int speed;
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

    private long userId;  // prendere id da connesso

    private List<SlotDto> slots;  // Lista di SlotDto
    private BagDto bag;  // DTO per la borsa
    private DiaryDto diary;  // DTO per il diario

    private List<AbilityPgDto> abilityPgs;  // Lista di AbilityPgDto
    private List<StaticDto> staticList;  // Lista di StaticDto
    private List<TiriSalvezzaDto> tiriSalvezza;  // Lista di TiriSalvezzaDto

    private long campaignId;

    private List<TalentDto> talents;  // Lista di TalentDto
    private List<TraitDto> traits;  // Lista di TraitDto





    public CharacterPgDto(){

    }

    public CharacterPgDto(long id, String name, String surname, String classe, String race, int level, String background, String allignment, int exp, String physicalTrait, int ispiration, int bonusCompetence, int perception, int ca, int iniziative, int speed, int totalHp, int actualHp, int temporanyHp, int dice, int diceHealth, String caratterial, String ideals, String note, int money, String img, long userId, List<SlotDto> slots, BagDto bag, DiaryDto diary, List<AbilityPgDto> abilityPgs, List<StaticDto> staticList, List<TiriSalvezzaDto> tiriSalvezza, long campaignId, List<TalentDto> talents, List<TraitDto> traits) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.classe = classe;
        this.race = race;
        this.level = level;
        this.background = background;
        this.allignment = allignment;
        this.exp = exp;
        this.physicalTrait = physicalTrait;
        this.ispiration = ispiration;
        this.bonusCompetence = bonusCompetence;
        this.perception = perception;
        this.ca = ca;
        this.iniziative = iniziative;
        this.speed = speed;
        this.totalHp = totalHp;
        this.actualHp = actualHp;
        this.temporanyHp = temporanyHp;
        this.dice = dice;
        this.diceHealth = diceHealth;
        this.caratterial = caratterial;
        this.ideals = ideals;
        this.note = note;
        this.money = money;
        this.img = img;
        this.userId = userId;
        this.slots = slots;
        this.bag = bag;
        this.diary = diary;
        this.abilityPgs = abilityPgs;
        this.staticList = staticList;
        this.tiriSalvezza = tiriSalvezza;
        this.campaignId = campaignId;
        this.talents = talents;
        this.traits = traits;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<SlotDto> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotDto> slots) {
        this.slots = slots;
    }

    public BagDto getBag() {
        return bag;
    }

    public void setBag(BagDto bag) {
        this.bag = bag;
    }

    public DiaryDto getDiary() {
        return diary;
    }

    public void setDiary(DiaryDto diary) {
        this.diary = diary;
    }

    public List<AbilityPgDto> getAbilityPgs() {
        return abilityPgs;
    }

    public void setAbilityPgs(List<AbilityPgDto> abilityPgs) {
        this.abilityPgs = abilityPgs;
    }

    public List<StaticDto> getStaticList() {
        return staticList;
    }

    public void setStaticList(List<StaticDto> staticList) {
        this.staticList = staticList;
    }

    public List<TiriSalvezzaDto> getTiriSalvezza() {
        return tiriSalvezza;
    }

    public void setTiriSalvezza(List<TiriSalvezzaDto> tiriSalvezza) {
        this.tiriSalvezza = tiriSalvezza;
    }

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public List<TalentDto> getTalents() {
        return talents;
    }

    public void setTalents(List<TalentDto> talents) {
        this.talents = talents;
    }

    public List<TraitDto> getTraits() {
        return traits;
    }

    public void setTraits(List<TraitDto> traits) {
        this.traits = traits;
    }
}
