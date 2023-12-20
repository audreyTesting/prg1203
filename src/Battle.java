import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle{
    private List<Pokemon> availablePokemons = new ArrayList<>();
    private Pokemon opponentPokemon1;
    private Pokemon opponentPokemon2;

    public void initializeBattle(List<Pokemon> availablePokemons) {
        if (availablePokemons.isEmpty()) {
            System.out.println("No available Pokemons!");
            return;
        }

        this.availablePokemons = availablePokemons;
        opponentPokemon1 = generateRandomPokemon();
        opponentPokemon2 = generateRandomPokemon();
        System.out.println("\t—------------------------------------------------");
        System.out.println("\t ----------------! Battle Time !----------------");
        System.out.println("\t—------------------------------------------------");
        System.out.println("\tOpponent's Pokemon: ");
        System.out.println(opponentPokemon1.toString());
        System.out.println(opponentPokemon2.toString());
    }


    private Pokemon generateRandomPokemon() {
        Random random = new Random();
        Pokemon randomPokemon = availablePokemons.get(random.nextInt(availablePokemons.size()));
        return randomPokemon;
    }



}