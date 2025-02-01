package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.entities.Slot;
import progettino.dnd.projectDnd.model.entities.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpellDto {
    private long id;
    private String name;
    private String description;
    private String actionTime;
    private int gittate;  // distanza o gittata dell'incantesimo
    private int duration;  // durata dell'incantesimo
    private int dice;  // i dadi utilizzati per calcolare i danni, ad esempio
    private int hitDice;  // dadi per il colpo
    private int healthDice;  // dadi per la salute
    private String component;  // componenti richiesti per l'incantesimo (es. verbale, somatico, materiale)
    private boolean preparate;  // se l'incantesimo è preparato
    private int minLevel;  // livello minimo per l'incantesimo
    private Type type;  

    private List<SlotDto> slots;  // Lista di SlotDto che contengono questo incantesimo



    public SpellDto(){

    }

    public SpellDto(long id, String name, String description, String actionTime, int gittate, int duration, int dice, int hitDice, int healthDice, String component, boolean preparate, int minLevel, Type type, List<SlotDto> slots) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.actionTime = actionTime;
        this.gittate = gittate;
        this.duration = duration;
        this.dice = dice;
        this.hitDice = hitDice;
        this.healthDice = healthDice;
        this.component = component;
        this.preparate = preparate;
        this.minLevel = minLevel;
        this.type = type;
        this.slots = slots;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<SlotDto> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotDto> slots) {
        this.slots = slots;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public boolean isPreparate() {
        return preparate;
    }

    public void setPreparate(boolean preparate) {
        this.preparate = preparate;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public int getHealthDice() {
        return healthDice;
    }

    public void setHealthDice(int healthDice) {
        this.healthDice = healthDice;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getGittate() {
        return gittate;
    }

    public void setGittate(int gittate) {
        this.gittate = gittate;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SpellDto fromEntity(Spell spell) {
        if (spell == null) {
            return null;
        }

        SpellDto spellDto = new SpellDto();
        spellDto.setId(spell.getId());
        spellDto.setName(spell.getName());
        spellDto.setDescription(spell.getDescription());
        spellDto.setActionTime(spell.getActionTime());
        spellDto.setGittate(spell.getGittate());
        spellDto.setDuration(spell.getDuration());
        spellDto.setDice(spell.getDice());
        spellDto.setHitDice(spell.getHitDice());
        spellDto.setHealthDice(spell.getHealthDice());
        spellDto.setComponent(spell.getComponent());
        spellDto.setPreparate(spell.isPreparate());
        spellDto.setMinLevel(spell.getMinLevel());
        spellDto.setType(spell.getType());
        spellDto.setSlots(spell.getSlots() != null ? spell.getSlots().stream().map(SlotDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());


        return spellDto;
    }


    public Spell toEntity() {
        Spell spell = new Spell();
        spell.setId(this.id);
        spell.setName(this.name);
        spell.setDescription(this.description);
        spell.setActionTime(this.actionTime);
        spell.setGittate(this.gittate);
        spell.setDuration(this.duration);
        spell.setDice(this.dice);
        spell.setHitDice(this.hitDice);
        spell.setHealthDice(this.healthDice);
        spell.setComponent(this.component);
        spell.setPreparate(this.preparate);
        spell.setMinLevel(this.minLevel);
        spell.setType(this.type);
        spell.setSlots(this.slots != null ? this.slots.stream().map(SlotDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        return spell;
    }

}
