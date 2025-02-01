package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Charm;
import progettino.dnd.projectDnd.model.entities.Slot;
import progettino.dnd.projectDnd.model.entities.Type;

import java.util.ArrayList;
import java.util.List;

public class CharmDto {
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



    public CharmDto(){

    }

    public CharmDto(long id, String name, String description, String actionTime, int gittate, int duration, int dice, int hitDice, int healthDice, String component, boolean preparate, int minLevel, Type type, List<SlotDto> slots) {
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

    public static CharmDto fromEntity(Charm charm) {
        if (charm == null) {
            return null;
        }

        CharmDto charmDto = new CharmDto();
        charmDto.setId(charm.getId());
        charmDto.setName(charm.getName());
        charmDto.setDescription(charm.getDescription());
        charmDto.setActionTime(charm.getActionTime());
        charmDto.setGittate(charm.getGittate());
        charmDto.setDuration(charm.getDuration());
        charmDto.setDice(charm.getDice());
        charmDto.setHitDice(charm.getHitDice());
        charmDto.setHealthDice(charm.getHealthDice());
        charmDto.setComponent(charm.getComponent());
        charmDto.setPreparate(charm.isPreparate());
        charmDto.setMinLevel(charm.getMinLevel());
        charmDto.setType(charm.getType());

        // Converti la lista di Slot in SlotDto
        if (charm.getSlots() != null) {
            List<SlotDto> slotDtos = new ArrayList<>();
            for (Slot slot : charm.getSlots()) {
                SlotDto slotDto = SlotDto.fromEntity(slot); // Usa la conversione anche per Slot
                slotDtos.add(slotDto);
            }
            charmDto.setSlots(slotDtos);
        }

        return charmDto;
    }

    // Metodi di Conversione da DTO a Entity
    public static Charm toEntity(CharmDto charmDto) {
        if (charmDto == null) {
            return null;
        }

        Charm charm = new Charm();
        charm.setId(charmDto.getId());
        charm.setName(charmDto.getName());
        charm.setDescription(charmDto.getDescription());
        charm.setActionTime(charmDto.getActionTime());
        charm.setGittate(charmDto.getGittate());
        charm.setDuration(charmDto.getDuration());
        charm.setDice(charmDto.getDice());
        charm.setHitDice(charmDto.getHitDice());
        charm.setHealthDice(charmDto.getHealthDice());
        charm.setComponent(charmDto.getComponent());
        charm.setPreparate(charmDto.isPreparate());
        charm.setMinLevel(charmDto.getMinLevel());
        charm.setType(charmDto.getType());

        // Converti la lista di SlotDto in Slot
        if (charmDto.getSlots() != null) {
            List<Slot> slots = new ArrayList<>();
            for (SlotDto slotDto : charmDto.getSlots()) {
                Slot slot = SlotDto.toEntity(slotDto); // Usa la conversione anche per Slot
                slots.add(slot);
            }
            charm.setSlots(slots);
        }

        return charm;
    }
}
