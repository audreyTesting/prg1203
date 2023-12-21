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
        this.medals =100;
        this.inventory = new ArrayList<>();
        this.pokemons = new ArrayList<>();
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

    public void listPokemons() {
        // Implementation...
    }

    public Pokemon[] getPokemonst() {
        return null;
    }



    ///other methods
    public void choosePokemon() {
        System.out.println("Select a Pokemon to send out:");
        listPokemons();

        Pokemon[] playerPokemons = getPokemonst();
        if (playerPokemons.length > 0 && playerPokemons[0] != null) {
            Pokemon selectedPokemon = playerPokemons[0];
            System.out.println(getName() + " sends out " + selectedPokemon.getName() + "!");
        } else {
            System.out.println(getName() + " has no Pokemon to send out.");
        }
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
    }

    public void displayPokemons() {
        System.out.println("Pokemons owned by " + name + ":");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getName() + " - Level " + pokemon.getLevel());
        }
    }

    public void setInitialPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    //get Attack and Defense Values
    public List<Integer> getAttack() {
        List<Integer> atkValues = new ArrayList<>();

        for (int i = 0; i < pokemons.size(); i++) {
            int atk = pokemons.get(i).getAttack();
            atkValues.add(atk);
        }
        return atkValues;
    }

    public List<Integer> getDefense() {
        List<Integer> defValues = new ArrayList<>();

        for (int i = 0; i < pokemons.size(); i++) {
            int def = pokemons.get(i).getDefense();
            defValues.add(def);
        }
        return defValues;
    }


}
