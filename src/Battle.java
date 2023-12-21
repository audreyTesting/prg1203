import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle{

    private Player player;
    private List<Pokemon> availablePokemons = new ArrayList<>();
    private Pokemon opponentPokemon1;
    private Pokemon opponentPokemon2;
    private Scanner scanner;

    //private int initialPlayerAttack = playerAttackDamage;



    public Battle() {
        player = new Player();
        scanner = new Scanner(System.in);
    }


    public Pokemon getOpponentPokemon1() {
        return opponentPokemon1;
    }

    public Pokemon getOpponentPokemon2() {
        return opponentPokemon2;
    }

    public void initializeOpponentPokemons(Pokemon pokemon1, Pokemon pokemon2) {
        this.opponentPokemon1 = pokemon1;
        this.opponentPokemon2 = pokemon2;
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

            return null;
        }


        return chosenPokemons;
    }


    public void startBattle(List<Pokemon> playerChoices, Pokemon opponentPokemon1, Pokemon opponentPokemon2,List<Item> playerInventory) {


        while(arePlayersPokeAlive(playerChoices)&&(opponentPokemon1.getHp()>0||opponentPokemon2.getHp()>0)) {

            //display player Pokemon and their Hp
            System.out.println("\t—------------------------------------------------");
            System.out.println("\tYOUR POKEMONS");
            System.out.println("\t—------------------------------------------------");
            int i=1;
            for (Pokemon playerPokemon : playerChoices) {
                System.out.println("\t\t["+ i+ "] "+playerPokemon.getName() + " \t(HP: " + playerPokemon.getHp() + ") ");
                i++;
            }

            // Display opponent's Pokémon and their HP
            System.out.println("\t—------------------------------------------------");
            System.out.println("\tOPPONENT'S POKEMON");
            System.out.println("\t—------------------------------------------------");
            System.out.println("\t\t[1] "+opponentPokemon1.getName() + " \t(HP: " + opponentPokemon1.getHp() + ")" );
            System.out.println("\t\t[2] "+opponentPokemon2.getName() + " \t(HP: " + opponentPokemon2.getHp() + ")");
            System.out.println("\t—------------------------------------------------");

            //Players turn
            System.out.println("\tPlayer's turn:");
            System.out.println("\t[1] Attack");
            System.out.println("\t[2] Use Item");
            System.out.print("\t>>Choose an option: ");
            int playerChoice = scanner.nextInt();


            switch (playerChoice) {
                case 1:
                    //attack option
                    System.out.println("\t>>Choose which Pokemon to use:");
                    int chosenPokemonIndex = scanner.nextInt() - 1;
                    if (chosenPokemonIndex >= 0 && chosenPokemonIndex < playerChoices.size()) {
                        Pokemon playerPokemon = playerChoices.get(chosenPokemonIndex);

                        //choose which opponent Pokemon to attack
                        System.out.println("\t>>Which Opponent Pokemon to attack? (1 or 2):");
                        int chosenOpponentIndex = scanner.nextInt();

                        Pokemon opponent;
                        if (chosenOpponentIndex == 1) {
                            opponent = opponentPokemon1;
                            int damageDealt = playerPokemon.calculateDamage(opponentPokemon1);
                            opponent.takeDamage(damageDealt);
                            System.out.println("\t"+playerPokemon.getName() + " dealt " + damageDealt + " damage to " + opponent.getName());
                        } else if (chosenOpponentIndex == 2) {
                            opponent = opponentPokemon2;
                            int damageDealt = playerPokemon.calculateDamage(opponentPokemon2);
                            opponent.takeDamage(damageDealt);
                            System.out.println("\t"+playerPokemon.getName() + " dealt " + damageDealt + " damage to " + opponent.getName());
                        } else {
                            System.out.println("Invalid choice for the opponent Pokémon.");
                            continue;
                        }
                    }
                case 2:
                    //use item option
                    System.out.println("Select an item to use:");
                    int itemCount = 1;
                    for (Item item : playerInventory) {
                        System.out.println(itemCount + ". " + item.getName());
                        itemCount++;
                    }
                    if (playerInventory.isEmpty()) {
                        System.out.println("Your inventory is empty!");
                    } else {
                        System.out.print("Enter the number of the item to use: ");
                        int itemIndex = scanner.nextInt();

                        //validate item index
                        if (itemIndex > 0 && itemIndex <= playerInventory.size()) {
                            Item selectedItem = playerInventory.get(itemIndex - 1);
                            int effect = selectedItem.getItemEffect();

                            switch (itemIndex) {
                                case 1: // Attack Capsule
                                    // Apply an attack boost to player's Pokémon
                                    for (Pokemon pokemon : playerChoices) {
                                        int newAttack = pokemon.getAttack() + effect;
                                        pokemon.setAttack(newAttack);
                                        System.out.println(selectedItem.getName() + " used! " + pokemon.getName() + " attack boosted by " + effect);
                                    }
                                    break;

                                case 2: //Defense capsule
                                    // Apply a defense boost to player's Pokémon
                                    for (Pokemon pokemon : playerChoices) {
                                        int newDefense = pokemon.getDefense() + effect;
                                        pokemon.setDefense(newDefense);
                                        System.out.println(selectedItem.getName() + " used! " + pokemon.getName() + " defense boosted by " + effect);
                                    }
                                    break;

                                case 3: //Quicker drink
                                    //speed up attack move
                                    for (Pokemon pokemon : playerChoices) {
                                        int newSpeed = pokemon.getSpeed() + effect;
                                        pokemon.setSpeed(newSpeed);
                                        System.out.println(selectedItem.getName() + " used! " + pokemon.getName() + " speed boosted by " + effect);
                                    }
                                    break;
                                case 4: // Freezer poison
                                    // Slows down the opponent speed
                                    if (opponentPokemon1.getHp() > 0) {
                                        int newSpeed = opponentPokemon1.getSpeed() - effect;
                                        opponentPokemon1.setSpeed(newSpeed);
                                        System.out.println(selectedItem.getName() + " used! Freezer poison on " + opponentPokemon1.getName() + " reducing its speed by " + effect);
                                    }
                                    if (opponentPokemon2.getHp() > 0) {
                                        int newSpeed = opponentPokemon2.getSpeed() - effect;
                                        opponentPokemon2.setSpeed(newSpeed);
                                        System.out.println(selectedItem.getName() + " used! Freezer poison on " + opponentPokemon2.getName() + " reducing its speed by " + effect);
                                    }
                                    break;
                                case 5: // Support Pokemon
                                    // Hidden pokemon attacks the opponent
                                    // Subtract the item effect from opponent's HP
                                    if (opponentPokemon1.getHp() > 0) {
                                        int newHp = opponentPokemon1.getHp() - effect;
                                        opponentPokemon1.setHp(newHp);
                                        System.out.println(selectedItem.getName() + " used! Hidden Pokémon attacks " + opponentPokemon1.getName() + " reducing its HP by " + effect);
                                    }
                                    if (opponentPokemon2.getHp() > 0) {
                                        int newHp = opponentPokemon2.getHp() - effect;
                                        opponentPokemon2.setHp(newHp);
                                        System.out.println(selectedItem.getName() + " used! Hidden Pokémon attacks " + opponentPokemon2.getName() + " reducing its HP by " + effect);
                                    }
                                    break;

                                case 6: // Spirit Drink
                                    // Increase player's HP by the effect amount
                                    for (Pokemon pokemon : playerChoices) {
                                        int newHP = pokemon.getHp() + effect;
                                        // Ensure HP doesn't exceed the maximum
                                        if (newHP > pokemon.getMaxHP()) {
                                            newHP = pokemon.getMaxHP();
                                        }
                                        pokemon.setHp(newHP);
                                        System.out.println(selectedItem.getName() + " used! " + pokemon.getName() + "'s HP increased by " + effect);
                                    }
                                    break;
                            }

                        }
                    }
            }
        }

    }

    private boolean arePlayersPokeAlive(List<Pokemon> playerChoices) {
        for (Pokemon pokemon : playerChoices) {
            if (pokemon.getHp() > 0) {
                return true; // At least one Pokémon is still alive
            }
        }
        return false; // No Pokémon is alive
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