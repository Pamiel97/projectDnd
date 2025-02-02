package progettino.dnd.projectDnd.dtos;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    private List<SlotDto> slots;

    private BagDto bag;

    private DiaryDto diary;  // DTO per il diario

    private List<AbilityPgDto> abilityPgs;

    private List<StaticDto> staticList;

    private List<TiriSalvezzaDto> tiriSalvezza;  // Lista di TiriSalvezzaDto

    private long campaignId;

    private List<TalentDto> talents;

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

    public static CharacterPgDto fromEntity(CharacterPg character) {
        CharacterPgDto dto = new CharacterPgDto();
        dto.setId(character.getId());
        dto.setName(character.getName());
        dto.setSurname(character.getSurname());
        dto.setClasse(character.getClasse());
        dto.setRace(character.getRace());
        dto.setLevel(character.getLevel());
        dto.setBackground(character.getBackground());
        dto.setAllignment(character.getAllignment());
        dto.setExp(character.getExp());
        dto.setPhysicalTrait(character.getPhysicalTrait());
        dto.setIspiration(character.getIspiration());
        dto.setBonusCompetence(character.getBonusCompetence());
        dto.setPerception(character.getPerception());
        dto.setCa(character.getCa());
        dto.setIniziative(character.getIniziative());
        dto.setSpeed(character.getSpeed());
        dto.setTotalHp(character.getTotalHp());
        dto.setActualHp(character.getActualHp());
        dto.setTemporanyHp(character.getTemporanyHp());
        dto.setDice(character.getDice());
        dto.setDiceHealth(character.getDiceHealth());
        dto.setCaratterial(character.getCaratterial());
        dto.setIdeals(character.getIdeals());
        dto.setNote(character.getNote());
        dto.setMoney(character.getMoney());
        dto.setImg(character.getImg());
        dto.setUserId(character.getUser().getId());
        dto.setCampaignId(character.getCampaign().getId());
        dto.setSlots(character.getSlots() != null ? character.getSlots().stream().map(SlotDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());
        dto.setBag(character.getBag() != null ? BagDto.fromEntity(character.getBag()) : null);
        dto.setDiary(character.getDiary() != null ? DiaryDto.fromEntity(character.getDiary()) : null);
        dto.setAbilityPgs(character.getAbilityPgs() != null ? character.getAbilityPgs().stream().map(AbilityPgDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());
        dto.setStaticList(character.getStaticList() != null ? character.getStaticList().stream().map(StaticDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());
        dto.setTiriSalvezza(character.getTiriSalvezza() != null ? character.getTiriSalvezza().stream().map(TiriSalvezzaDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());
        dto.setTalents(character.getTalents() != null ? character.getTalents().stream().map(TalentDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());
        dto.setTraits(character.getTraits() != null ? character.getTraits().stream().map(TraitDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());
        return dto;
    }

    public CharacterPg toEntity() {
        CharacterPg character = new CharacterPg();
        character.setId(this.id);
        character.setName(this.name);
        character.setSurname(this.surname);
        character.setClasse(this.classe);
        character.setRace(this.race);
        character.setLevel(this.level);
        character.setBackground(this.background);
        character.setAllignment(this.allignment);
        character.setExp(this.exp);
        character.setPhysicalTrait(this.physicalTrait);
        character.setIspiration(this.ispiration);
        character.setBonusCompetence(this.bonusCompetence);
        character.setPerception(this.perception);
        character.setCa(this.ca);
        character.setIniziative(this.iniziative);
        character.setSpeed(this.speed);
        character.setTotalHp(this.totalHp);
        character.setActualHp(this.actualHp);
        character.setTemporanyHp(this.temporanyHp);
        character.setDice(this.dice);
        character.setDiceHealth(this.diceHealth);
        character.setCaratterial(this.caratterial);
        character.setIdeals(this.ideals);
        character.setNote(this.note);
        character.setMoney(this.money);
        character.setImg(this.img);

        character.setSlots(this.slots != null ? this.slots.stream().map(SlotDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
//        character.setBag(this.bag != null ? this.bag.toEntity() : null);
//        character.setDiary(this.diary != null ? this.diary.toEntity() : null);
        character.setAbilityPgs(this.abilityPgs != null ? this.abilityPgs.stream().map(AbilityPgDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        character.setStaticList(this.staticList != null ? this.staticList.stream().map(StaticDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        character.setTiriSalvezza(this.tiriSalvezza != null ? this.tiriSalvezza.stream().map(TiriSalvezzaDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        character.setTalents(this.talents != null ? this.talents.stream().map(TalentDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        character.setTraits(this.traits != null ? this.traits.stream().map(TraitDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        return character;
    }




}



