package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Weapon;

public class WeaponDto {
    private long id;
    private String name;
    private String description;
    private String magicEffect;  // Effetto magico dell'arma, se presente
    private int dice;            // Dadi per il danno, ad esempio 1d6
    private int diceAttack;      // Dadi per l'attacco
    private String note;         // Eventuali note aggiuntive sull'arma
    private int cost;            // Costo dell'arma

    private BagDto bag;


    public WeaponDto() {
    }

    public WeaponDto(long id, String name, String description, String magicEffect, int dice, int diceAttack, String note, int cost, BagDto bag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.magicEffect = magicEffect;
        this.dice = dice;
        this.diceAttack = diceAttack;
        this.note = note;
        this.cost = cost;
        this.bag = bag;
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

    public String getMagicEffect() {
        return magicEffect;
    }

    public void setMagicEffect(String magicEffect) {
        this.magicEffect = magicEffect;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getDiceAttack() {
        return diceAttack;
    }

    public void setDiceAttack(int diceAttack) {
        this.diceAttack = diceAttack;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public BagDto getBag() {
        return bag;
    }

    public void setBag(BagDto bag) {
        this.bag = bag;
    }


    public static WeaponDto fromEntity(Weapon weapon) {
        if (weapon == null) {
            return null;
        }

        WeaponDto weaponDto = new WeaponDto();
        weaponDto.setId(weapon.getId());
        weaponDto.setName(weapon.getName());
        weaponDto.setDescription(weapon.getDescription());
        weaponDto.setMagicEffect(weapon.getMagicEffect());
        weaponDto.setDice(weapon.getDice());
        weaponDto.setDiceAttack(weapon.getDiceAttack());
        weaponDto.setNote(weapon.getNote());
        weaponDto.setCost(weapon.getCost());

        // Converti Bag in BagDto
        if (weapon.getBag() != null) {
            BagDto bagDto = BagDto.fromEntity(weapon.getBag()); // Conversione da Bag a BagDto
            weaponDto.setBag(bagDto);
        }

        return weaponDto;
    }
    //TODO
    public Weapon toEntity() {

        Weapon weapon = new Weapon();
        weapon.setId(this.id);
        weapon.setName(this.name);
        weapon.setDescription(this.description);
        weapon.setMagicEffect(this.magicEffect);
        weapon.setDice(this.dice);
        weapon.setDiceAttack(this.diceAttack);
        weapon.setNote(this.note);
        weapon.setCost(this.cost);

        //


        return weapon;
    }
}

