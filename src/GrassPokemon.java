
public class GrassPokemon extends Pokemon{

    //constructors
    public GrassPokemon(int index, String name, int level,int hp, int defense, int attack, int speed, String ability) {
        super(index, name, level, "Grass" ,hp, defense, attack, speed,ability);
    }


    //strings
    @Override
    public String toString() {
        return String.format("Index [%d]", super.toString());
    }

}
