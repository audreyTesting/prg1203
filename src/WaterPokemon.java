public class WaterPokemon extends Pokemon{

    //constructors
    public WaterPokemon(int index, String name, int level, String type, String ability, String species) {
        super(index, name, level,"Water" ,ability, species);
    }


    //strings
    @Override
    public String toString() {
        return String.format("Index [%d]", super.toString());
    }

}