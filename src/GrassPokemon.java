
public class GrassPokemon extends Pokemon{

    //constructors
    public GrassPokemon(int index, String name, int level, String type,String ability, String species) {
        super(index, name, level,"Grass" ,ability, species);
    }


    //strings
    @Override
    public String toString() {
        return String.format("Index [%d]", super.toString());
    }

}
