import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle{

    private Player player;
    private List<Pokemon> availablePokemons = new ArrayList<>();
    private Pokemon opponentPokemon1;
    private Pokemon opponentPokemon2;

    public Battle() {
        player = new Player();
    }

    public Pokemon getOpponentPokemon1() {
        return opponentPokemon1;
    }

    public Pokemon getOpponentPokemon2() {
        return opponentPokemon2;
    }

    public void initializeBattle(List<Pokemon> availablePokemons) {
        if (availablePokemons.isEmpty()) {
            System.out.println("\tNo available Pokemons!");
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

    public List<Pokemon> playerChoosePokemon() {
        List<Pokemon> allPokemons = player.getPokemons();
        System.out.println("\n\tChoose your Pokémon for the battle (Select 2):");

        // Display owned Pokémon for selection
        for (int i = 0; i < allPokemons.size(); i++) {
            Pokemon pokemon = allPokemons.get(i);
            System.out.println("\t[" + (i + 1) + "]\t " + pokemon.getName() +
                    " \n\t\tType\t: " + pokemon.getType() +
                    " \n\t\tLevel\t: " + pokemon.getLevel() +
                    " \n\t\tHP\t: " + pokemon.getHp() +
                    " \n\t\tAttack\t: " + pokemon.getAttack() +
                    " \n\t\tDefense\t: " + pokemon.getDefense() +
                    " \n\t\tSpeed\t: " + pokemon.getSpeed() +
                    " \n\t\tAbility\t: " + pokemon.getAbility()+"\n");
        }

        List<Pokemon> chosenPokemons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Choose the first Pokémon
        System.out.print("\tChoose your first Pokémon (enter number): ");
        int choice1 = scanner.nextInt();

        if (choice1 > 0 && choice1 <= allPokemons.size()) {
            chosenPokemons.add(allPokemons.get(choice1 - 1));
        } else {
            System.out.println("\tInvalid choice for the first Pokémon!");
            scanner.close();
            return null;
        }

        // Choose the second Pokémon
        System.out.print("\tChoose your second Pokémon (enter number): ");
        int choice2 = scanner.nextInt();

        if (choice2 > 0 && choice2 <= allPokemons.size() && choice2 != choice1) {
            chosenPokemons.add(allPokemons.get(choice2 - 1));
        } else {
            System.out.println("\tInvalid choice for the second Pokémon!");
            scanner.close();
            return null;
        }

        scanner.close();
        return chosenPokemons;
    }


    public void startBattle(List<Pokemon> playerChoices, Pokemon opponent1, Pokemon opponent2) {

    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Pokemon generateRandomPokemon() {
        Random random = new Random();
        Pokemon randomPokemon = availablePokemons.get(random.nextInt(availablePokemons.size()));
        return randomPokemon;
    }



}