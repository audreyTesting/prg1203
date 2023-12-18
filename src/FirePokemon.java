public class FirePokemon extends Pokemon{

    //constructors
    public FirePokemon(int index, String name, int level,int hp, int defense, int attack, int speed, String ability) {
        super(index, name, level, "Fire" ,hp, defense, attack, speed,ability);
    }


    //strings
    @Override
    public String toString() {
        return String.format("Index [%d]", super.toString());
    }

}