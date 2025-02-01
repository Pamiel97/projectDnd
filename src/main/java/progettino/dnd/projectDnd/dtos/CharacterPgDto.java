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

    @JsonIgnore
    private List<SlotDto> slots;
    @JsonIgnore
    @JsonBackReference// Lista di SlotDto
    private BagDto bag;
    @JsonIgnore
    @JsonManagedReference// DTO per la borsa
    private DiaryDto diary;  // DTO per il diario
    @JsonIgnore
    private List<AbilityPgDto> abilityPgs;
    @JsonIgnore// Lista di AbilityPgDto
    private List<StaticDto> staticList;
    @JsonIgnore// Lista di StaticDto
    private List<TiriSalvezzaDto> tiriSalvezza;  // Lista di TiriSalvezzaDto

    private long campaignId;
    @JsonIgnore
    private List<TalentDto> talents;
    @JsonIgnore// Lista di TalentDto
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

    public static CharacterPgDto fromEntity(CharacterPg characterPg) {
        if (characterPg == null) {
            return null;
        }

        CharacterPgDto dto = new CharacterPgDto();
        dto.setId(characterPg.getId());
        dto.setName(characterPg.getName());
        dto.setSurname(characterPg.getSurname());
        dto.setClasse(characterPg.getClasse());
        dto.setRace(characterPg.getRace());
        dto.setLevel(characterPg.getLevel());
        dto.setBackground(characterPg.getBackground());
        dto.setAllignment(characterPg.getAllignment());
        dto.setExp(characterPg.getExp());
        dto.setPhysicalTrait(characterPg.getPhysicalTrait());
        dto.setIspiration(characterPg.getIspiration());
        dto.setBonusCompetence(characterPg.getBonusCompetence());
        dto.setPerception(characterPg.getPerception());
        dto.setCa(characterPg.getCa());
        dto.setIniziative(characterPg.getIniziative());
        dto.setSpeed(characterPg.getSpeed());
        dto.setTotalHp(characterPg.getTotalHp());
        dto.setActualHp(characterPg.getActualHp());
        dto.setTemporanyHp(characterPg.getTemporanyHp());
        dto.setDice(characterPg.getDice());
        dto.setDiceHealth(characterPg.getDiceHealth());
        dto.setCaratterial(characterPg.getCaratterial());
        dto.setIdeals(characterPg.getIdeals());
        dto.setNote(characterPg.getNote());
        dto.setMoney(characterPg.getMoney());
        dto.setImg(characterPg.getImg());

        dto.setUserId(characterPg.getUser() != null ? characterPg.getUser().getId() : 0);
        dto.setCampaignId(characterPg.getCampaign() != null ? characterPg.getCampaign().getId() : 0);

        dto.setSlots(characterPg.getSlots().stream().map(SlotDto::fromEntity).collect(Collectors.toList()));
        dto.setAbilityPgs(characterPg.getAbilityPgs().stream().map(AbilityPgDto::fromEntity).collect(Collectors.toList()));
        dto.setStaticList(characterPg.getStaticList().stream().map(StaticDto::fromEntity).collect(Collectors.toList()));
        dto.setTiriSalvezza(characterPg.getTiriSalvezza().stream().map(TiriSalvezzaDto::fromEntity).collect(Collectors.toList()));
        dto.setTalents(characterPg.getTalents().stream().map(TalentDto::fromEntity).collect(Collectors.toList()));
        dto.setTraits(characterPg.getTraits().stream().map(TraitDto::fromEntity).collect(Collectors.toList()));

        if (characterPg.getBag() != null) {
            dto.setBag(BagDto.fromEntity(characterPg.getBag()));
        }
        if (characterPg.getDiary() != null) {
            dto.setDiary(DiaryDto.fromEntity(characterPg.getDiary()));
        }

        return dto;
    }

    public CharacterPg toEntity(User user, Campaign campaign) {
        CharacterPg characterPg = new CharacterPg();
        characterPg.setId(this.id);
        characterPg.setName(this.name);
        characterPg.setSurname(this.surname);
        characterPg.setClasse(this.classe);
        characterPg.setRace(this.race);
        characterPg.setLevel(this.level);
        characterPg.setBackground(this.background);
        characterPg.setAllignment(this.allignment);
        characterPg.setExp(this.exp);
        characterPg.setPhysicalTrait(this.physicalTrait);
        characterPg.setIspiration(this.ispiration);
        characterPg.setBonusCompetence(this.bonusCompetence);
        characterPg.setPerception(this.perception);
        characterPg.setCa(this.ca);
        characterPg.setIniziative(this.iniziative);
        characterPg.setSpeed(this.speed);
        characterPg.setTotalHp(this.totalHp);
        characterPg.setActualHp(this.actualHp);
        characterPg.setTemporanyHp(this.temporanyHp);
        characterPg.setDice(this.dice);
        characterPg.setDiceHealth(this.diceHealth);
        characterPg.setCaratterial(this.caratterial);
        characterPg.setIdeals(this.ideals);
        characterPg.setNote(this.note);
        characterPg.setMoney(this.money);
        characterPg.setImg(this.img);

        characterPg.setUser(user);
        characterPg.setCampaign(campaign);

        return characterPg;
    }

    public static BagDto fromEntity(Bag bag) {
        if (bag == null) {
            return null;
        }

        BagDto dto = new BagDto();
        dto.setId(bag.getId());
        dto.setPg(CharacterPgDto.fromEntity(bag.getPg()));
        dto.setPotions(bag.getPotions().stream().map(PotionDto::fromEntity).collect(Collectors.toList()));
        dto.setEquips(bag.getEquips().stream().map(EquipDto::fromEntity).collect(Collectors.toList()));
        dto.setWeapons(bag.getWeapons().stream().map(WeaponDto::fromEntity).collect(Collectors.toList()));
        dto.setObjects(bag.getObjects().stream().map(ObjectDto::fromEntity).collect(Collectors.toList()));

        return dto;
    }

    // Convert from DTO to Entity
    public Bag toEntity(CharacterPg characterPg) {
        Bag bag = new Bag();
        bag.setId(this.id);
        bag.setPg(characterPg);
        return bag;
    }
}



