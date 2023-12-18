
public class Pokemon {

    //attributes
    private int index;
    private String name;
    private int level;
    private String type;
    private int hp;
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
//	public void level() {
//        hp = hp * level; // tentatively
//    }



    @Override
    public String toString() {
        return "Index: " + index + ", name: " + name + ", level: " + level + ", type: " + type + ", hp: " + hp
                + ", defense: " + defense + ", attack: " + attack + ", speed: " + speed + ", ability: " + ability ;
    }



}








