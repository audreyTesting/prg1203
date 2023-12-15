import java.util.ArrayList;
import java.util.List;

public class Player {

    //attributes
    private String name;
    private int medals;
    private List<Item> inventory;
    private List<Pokemon> pokemons;

    //empty constructor
    public Player() {
        inventory = new ArrayList<>();
        pokemons = new ArrayList<>();
    }

    //setters getters
    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMedals() {
        return medals;
    }

    public void setMedals(int medals) {
        this.medals = medals;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }


    //other methods
    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
    }


}
