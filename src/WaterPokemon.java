public class WaterPokemon extends Pokemon{

    //constructors
    public WaterPokemon(int index, String name, int level,int hp, int defense, int attack, int speed, String ability) {
        super(index, name, level, "Water" ,hp, defense, attack, speed,ability);
    }


    //strings
    @Override
    public String toString() {
        return String.format("Index [%d]", super.toString());
    }

}