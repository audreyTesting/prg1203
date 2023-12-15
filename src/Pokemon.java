
public class Pokemon {

    //attributes
    private int index;
    private String name;
    private int level;
    private String type;
    private String ability;
    private String species;


    //constructors
    public Pokemon() {

    }

    public Pokemon(int index, String name, int level,String type, String ability, String species) {
        super();
        this.index = index;
        this.name = name;
        this.level = level;
        this.type = type;
        this.ability = ability;
        this.species = species;
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

    public String getAbility() {
        return ability;
    }

    public String getSpecies() {
        return species;
    }

    //other methods

    //toString
    @Override
    public String toString() {
        return String.format("Name : %s/n Level : %d/n Ability : %s\n Species : %s", name,level,ability,species);
    }



}
