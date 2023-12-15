public class FirePokemon extends Pokemon{

    //constructors
    public FirePokemon(int index, String name, int level, String type, String ability, String species) {
        super(index, name, level, "Fire" ,ability, species);
    }


    //strings
    @Override
    public String toString() {
        return String.format("Index [%d]", super.toString());
    }

}