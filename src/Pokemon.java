

public class Pokemon {

    //attributes
    private int index;
    private String name;
    private int level;
    private String type;
    private int hp;
    private int maxHP = 300;
    private int defense;
    private int attack;
    private int speed;
    private String ability;


    //constructors
    public Pokemon() {

    }

    public Pokemon(int index, String name, int level,String type, int hp, int defense, int attack, int speed, String ability ) {
        super();
        this.index = index;
        this.name = name;
        this.level = level;
        this.type = type;
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
        this.speed = speed;
        this.ability = ability;

    }


    //setters getters
    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }
    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getDefense() {
        return defense;
    }
    public int getAttack () {
        return attack;
    }
    public int getSpeed() {
        return speed;
    }

    public String getAbility() {
        return ability;
    }


    //other methods
    public void takeDamage(int damage) {
        int actualDamage = calculateActualDamage(damage); // Consider defense, type advantages, etc.
        hp -= actualDamage;
        if (hp < 0) {
            hp = 0; // Ensure HP doesn't go negative
        }
    }

    private int calculateActualDamage(int damage) {
        // Implement logic to calculate actual damage based on defense, type advantages, etc.
        // For example:
        int actualDamage = damage - defense;
        if (actualDamage < 0) {
            actualDamage = 0; // Ensure damage doesn't become negative
        }
        return actualDamage;
    }

    public int calculateDamage(Pokemon opponent) {
        int damage;
        String type = this.getType();
        switch (type) {
            case "Fire":
                damage = (int) (this.getAttack() * 0.5) - opponent.getDefense();
                break;
            case "Water":
                damage = (int) (this.getAttack() * 0.5) - opponent.getDefense();
                break;
            case "Grass":
                damage = (int) (this.getAttack() * 2) - opponent.getDefense();
                break;
            default:
                damage = this.getAttack() - opponent.getDefense();
                break;
        }
        if (damage < 0) {
            damage = 0; // Ensure damage is not negative
        }
        return damage;
    }
    public void applyPowerUp(int boostAmount) {
        hp += boostAmount;
        // You might want to impose a maximum HP limit if needed
        if (hp > maxHP) {
            hp = maxHP; // Ensure HP doesn't exceed the maximum value
        }
    }

    public void reduceHp(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0; // Ensure HP doesn't go negative
        }
    }



    @Override
    public String toString() {
        return String.format(
                "\tIndex: %d%n\tName: %s%n\tLevel: %s%n\tType: %s%n\tHP: %d%n\tDefense: %d%n\tAttack: %d%n\tSpeed: %d%n\tAbility: %s",
                getIndex(), getName(), levelToStars(getLevel()), getType(), getHp(), getDefense(), getAttack(), getSpeed(), getAbility()
        );
    }

    private String levelToStars(int level) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < level; i++) {
            stars.append("★");
        }
        return stars.toString();
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }





}








