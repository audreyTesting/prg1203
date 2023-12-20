import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Game {

    //attributes
    private Player player;
    private Battle battle;
    private List <Item> availableItems;
    private List<Pokeball> balls = new ArrayList<>();
    private List<GrassPokemon> grassPokemon = new ArrayList<>();
    private List<FirePokemon> firePokemon= new ArrayList<>();
    private List<WaterPokemon> waterPokemon= new ArrayList<>();
    private List<Pokemon> availablePokemons = new ArrayList<>();
    private Scanner scanner;

    //empty constructor
    public Game() {
        player = new Player();
        battle= new Battle();
        battle.setPlayer(player);
        availableItems = new ArrayList<>();
        balls = new ArrayList<>();
        firePokemon = new ArrayList<>();
        waterPokemon = new ArrayList<>();
        grassPokemon = new ArrayList<>();
        availablePokemons = new ArrayList<>();
        availablePokemons.addAll(firePokemon);
        availablePokemons.addAll(waterPokemon);
        availablePokemons.addAll(grassPokemon);
        pokeballList();
        initializeItems();
        pokemonsList();
        initializePlayerWithPokemon();
        scanner = new Scanner(System.in);
    }

    //methods

    //starting the game
    public void start() {
        System.out.println("\n");
        System.out.println("\t—------------------------------------------------");
        System.out.println("\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⢿⣿⣿⡿⠋⣴⠧⣙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⣉⣥⣤⣤⣬⣉⠻⣿⣿⠋⢩⣤⡄⢀⣤⡙⠫⠀⡈⣀⣘⠻⠁⢠⣤⡀⣶⡆⢻⣿⡟⠉⣙⡛⠻⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⡁⠀⠿⣿⣿⣿⠛⠛⣿⡆⢹⠿⠄⠀⣿⣧⣾⡿⠋⠠⡿⠉⢉⡟⠁⠀⣿⣿⣇⣿⣷⠸⢛⢃⡀⢸⣿⣇⠀⣶⡶⢠⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠈⣿⣿⡇⠀⣾⠁⣰⠎⢹⠶⠸⣿⣿⣀⠁⠰⡿⣰⣏⣶⣶⠀⣾⡿⣿⣿⡏⢀⠁⢹⠏⠆⢿⣿⢰⣿⠇⣾⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⣿⣷⣷⠀⠘⣿⣿⡞⠁⢸⣿⣄⣉⣼⠃⣼⠙⠻⢿⣦⣉⡒⠛⢋⠀⢨⣿⠃⠫⢸⡀⣿⣶⣤⣾⢃⡞⣿⣾⡟⢰⣿⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠹⣿⣇⢀⠈⠻⠿⠟⠋⠸⠿⠀⣦⣄⡈⠙⠃⢸⣿⣤⣤⣄⣄⡀⠀⠷⠌⢉⡉⠀⠾⡇⣿⣿⢁⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠹⠟⠀⣷⣦⣶⣾⣦⣶⣶⣾⣿⣿⣿⣷⣦⣾⣿⣿⣿⣿⣿⣷⣶⣶⣤⣼⣷⣦⡄⠀⠛⠇⡼⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                + "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t—------------------------------------------------");
        System.out.println("\t ---------! WELCOME TO POKEMON GA OLE !---------");
        System.out.println("\t—------------------------------------------------");
        System.out.print("\tName: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);
        System.out.println("\n\tHello " + playerName + ",\n");

        int choice;
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    catchAndBattle();
                    //battle = new Battle();
                    battle.initializeBattle(availablePokemons);
                    break;
                case 2:
                    displayPokemons();
                    break;
                case 3:
                    displayStore();
                    break;
                case 4:
                    System.out.println("\tExiting the game. See you again!");
                    return;
                default:
                    System.out.println("\tInvalid choice. Please choose again.");
                    break;
            }
        } while (choice != 4);
    }

    // printing main menu
    private void displayMainMenu() {
        System.out.println("\t—------------------------------------------------");
        System.out.println("\n\tSelect:");
        System.out.println("\t[1] Catch and Battle");
        System.out.println("\t[2] Pokemons");
        System.out.println("\t[3] Stores");
        System.out.println("\t[4] Quit");

        System.out.print("\n\t>>Enter your choice: ");
    }

    private void initializePlayerWithPokemon() {
        //creating one pokemon for the player
        Pokemon initialPokemon = new Pokemon(556,"Maractus",1,"Grass",75,86,67,60,"Water Absorb");
        player.setInitialPokemon(initialPokemon);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    [1] CATCH AND BATTLE
//
//    		CATCH:
//    		- generate 1 random Pokeball
//    		- generate 3 random Pokemon to catch (display name + level)
//    		- player choose one out of 3
//
//    		BATTLE:
//    		- generate 2 wild pokemons
//    		- player choose 2 from their pokemons
//    		-
//
//

    //catch and battle mode
    private void catchAndBattle() {
        System.out.println("\t—------------------------------------------------");
        System.out.println("\t ---------! WELCOME TO Catch & Battle !---------");
        System.out.println("\t—------------------------------------------------");


        //create a list of caught pokemon
        List<Pokemon> userPokemonChoices = gnrRandPokemonList();
        boolean pokemonCaught = false;



        //catching process..
        // Loop until a Pokemon is caught or no more choices left
        while (!pokemonCaught && !userPokemonChoices.isEmpty()) {
            System.out.println("\n\tA pokemon ball is generating…");
            Pokeball randomPokeball = generateRandomPokeball();

            //if caught a pokemon
            System.out.println("\tTADAAA–! You got a \n" +"\t"+ randomPokeball.getName());
            System.out.println("\n\tPokemons caught !!");

            int count = 1;
            for (Pokemon pokemon : userPokemonChoices) {
                System.out.println("\t[" + count + "] " + pokemon.getName() + "\t" +levelToStars(pokemon.getLevel()));
                count++;
            }

            // Ask user to choose which Pokemon to catch
            System.out.print("\n\t>> Choose one to catch : ");
            int chosenIndex = scanner.nextInt();

            // Validate the input
            if (chosenIndex < 1 || chosenIndex > userPokemonChoices.size()) {
                System.out.println("\tInvalid choice. Please choose a number between 1 and " + userPokemonChoices.size());
                return;
            }

            // Get the chosen Pokemon
            Pokemon chosenPokemon = userPokemonChoices.get(chosenIndex - 1);

            // Check if the Pokemon is caught based on Pokeball's level
            if (chosenPokemon.getLevel() <= randomPokeball.getAvail()) {
                System.out.println("\n\t"+chosenPokemon.getName() + " was caught!");
                player.addPokemon(chosenPokemon); // Add the caught Pokemon to player's Pokemon list
                pokemonCaught = true;

            } else {
                System.out.println("\t OHNO!! "+chosenPokemon.getName() + " ran away...");
                System.out.println("\t—------------------------------------------------");
                userPokemonChoices.remove(chosenPokemon);
                if (userPokemonChoices.isEmpty()) {
                    System.out.println("\tTry Again! All pokemons had ran away!");
                    return;
                }
            }
        }

        //generate random pokemons for opponents
        List<Pokemon> randomPokemons = gnrRandPokemonList();
        availablePokemons.addAll(randomPokemons);


        //pokemon chose by the player to use in the battle
        List<Pokemon> playerChoices = battle.playerChoosePokemon();
        if (playerChoices != null && playerChoices.size() == 2) {
            System.out.println("\n\tYou've chosen your Pokémon for the battle!");

            battle.startBattle(playerChoices, battle.getOpponentPokemon1(), battle.getOpponentPokemon2());
        } else {
            System.out.println("\tYou need to choose 2 valid Pokémon!");
        }

    }



    //creating item into availableItems
    private void initializeItems() {
        availableItems.add(new Item("[1] Attack Capsule",	"Providint a attack boost in battle",		30));
        availableItems.add(new Item("[2] Defense Capsule",	"Provides defense boost during defense",	30));
        availableItems.add(new Item("[3] Quicker Drink",	"Speed up attack move during attack",		30));
        availableItems.add(new Item("[4] Aim BoostScope",		"Increase the chance of critical hit",		30));
        availableItems.add(new Item("[5] Support Pokemon",	"Unlocks a new Support pokemon in battle", 	30));
        availableItems.add(new Item("[6] Spirit Drink",		"Increase player's starting FP by 100%",	30));
    }

    //adding pokeball into balls
    private void pokeballList() {
        Pokeball ball1 = new Pokeball("Poke ball", 1,1);
        Pokeball ball2 = new Pokeball("Great ball", 2,2);
        Pokeball ball3 = new Pokeball("Ultra ball", 3,3);
        Pokeball ball4 = new Pokeball("Master ball", 4,4);
        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
        balls.add(ball4);
    }

    // generating random pokeball from balls
    private Pokeball generateRandomPokeball() {
        if (balls.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(balls.size()); // Get a random index within the list size
        return balls.get(randomIndex); // Return the Pokeball at the random index
    }

    //creating pokemons based on their type then add into their typePokemon
    private void pokemonsList() {
        //fire type
        FirePokemon fire1 = new FirePokemon(244,"Entei",4,115,115,85,100,"Pressure,Flash Fire");
        FirePokemon fire2 = new FirePokemon(555,"Darmaniltan",3,105,140,55,95,"Sheer Force, Zen Mode");
        FirePokemon fire3 = new FirePokemon(631,"Heatmor",2,85,97,66,65,"Gluttony, Flash Fire, White Smoke");
        FirePokemon fire4 = new FirePokemon(157,"Typhlosion",1,78,84,78,100,"Blaze, Flash Fire");
        firePokemon.add(fire1);
        firePokemon.add(fire2);
        firePokemon.add(fire3);
        firePokemon.add(fire4);

        //water type
        WaterPokemon water1 = new WaterPokemon(245,"Suicune",4,100,75,115,85,"Pressure, Water Absorb");
        WaterPokemon water2 = new WaterPokemon(382,"Kyogre",3,100,150,90,90,"Pimordial Sea");
        WaterPokemon water3 = new WaterPokemon(503,"Samurott",2,95,100,85,70,"Torrent, Shell Armor");
        WaterPokemon water4 = new WaterPokemon(186,"Politoed",1,90,75,75,70,"Water Absorb Damp Drizzle");
        waterPokemon.add(water1);
        waterPokemon.add(water2);
        waterPokemon.add(water3);
        waterPokemon.add(water4);

        //grass type
        GrassPokemon grass1 = new GrassPokemon(492,"Shaymin",4,100,100,100,100,"Natural Cure");
        GrassPokemon grass2 = new GrassPokemon(154,"Meganium",3,80,82,100,80,"Overgrow, leafguard");
        GrassPokemon grass3 = new GrassPokemon(182,"Bellossom",2,75,80,95,50,"Chlorophyll, Healer");
        GrassPokemon grass4 = new GrassPokemon(388,"Grotle",1,75,89,85,36,"Overgrow, Shell Armor");
        grassPokemon.add(grass1);
        grassPokemon.add(grass2);
        grassPokemon.add(grass3);
        grassPokemon.add(grass4);
    }

    //generate random pokemon from each type
    public List<Pokemon> gnrRandPokemonList(){
        List<Pokemon> randPokemonList = new ArrayList<>();

        Random random = new Random();

        //Fire
        FirePokemon randomFirePokemon = firePokemon.get(random.nextInt(firePokemon.size()));
        WaterPokemon randomWaterPokemon = waterPokemon.get(random.nextInt(waterPokemon.size()));
        GrassPokemon randomGrassPokemon = grassPokemon.get(random.nextInt(grassPokemon.size()));

        randPokemonList.add(randomFirePokemon);
        randPokemonList.add(randomWaterPokemon);
        randPokemonList.add(randomGrassPokemon);

        return randPokemonList;
    }





    // display list of pokemons
    private void displayPokemons() {
        List<Pokemon> allPokemons = new ArrayList<>();
        allPokemons.addAll(player.getPokemons());
        if (allPokemons.isEmpty()) {
            System.out.println("\n\tNo pokemons yet!\n");
        } else {
            System.out.println("\t—------------------------------------------------");
            System.out.println("\t ---------! WELCOME TO Pokemon Box !---------");
            System.out.println("\t—------------------------------------------------");
            System.out.println("\n\tHere are your pokemons:");
            for (Pokemon pokemon : allPokemons) {
                System.out.println(pokemon.toString());
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    	[2]	POKEMONS
//    			- display players' pokemon (including caught)
// 				- include name, hp, attack, defense, speed, ability, level
//
//

    private String levelToStars(int level) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < level; i++) {
            stars.append("★");
        }
        return stars.toString();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    	[3]	STORE
//    			- allows player to purchase item
//    			- if players' medal not enough, show insufficient
//
//


    //displaying stores and inventory
    private void displayStore() {
        System.out.println("\t—------------------------------------------------");
        System.out.println("\t ---------! WELCOME TO Poke Store !---------");
        System.out.println("\t—------------------------------------------------");
        System.out.println("\tYour Medals\t: " + player.getMedals());
        List<Item> inventory = player.getInventory();
        System.out.println("\n\tYour Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("\t(--empty--)");
        }
        else {
            System.out.println("\t—---------------------------------------------------------------------------------------------");
            System.out.println("\tName\t\t\tDescription\t\t\t\t\tAmount");
            System.out.println("\t—---------------------------------------------------------------------------------------------");

            for (int i = 0; i < inventory.size(); i++) {
                Item currentItem = inventory.get(i);

                // Skip if the item has already been counted
                if (inventory.subList(0, i).contains(currentItem)) {
                    continue;
                }

                int count = (int) inventory.stream().filter(item -> item.equals(currentItem)).count();
                System.out.println("\t" + currentItem.getName() + "\t" +
                        currentItem.getFunction() + "\t\t" +
                        count);
            }
            System.out.println("\t—---------------------------------------------------------------------------------------------");
        }

        displayAvailableItems();
        int storeChoice;
        do {
            displayStoreMenu();
            storeChoice = scanner.nextInt();
            switch (storeChoice) {
                case 1:
                    purchaseItem();
                    // After the purchase is made, display the updated inventory
                    System.out.println("\n\tYour Updated Inventory:");

                    // Display each unique item and its count again after the purchase
                    for (int i = 0; i < inventory.size(); i++) {
                        Item currentItem = inventory.get(i);

                        // Skip if the item has already been counted
                        if (inventory.subList(0, i).contains(currentItem)) {
                            continue;
                        }

                        int count = (int) inventory.stream().filter(item -> item.equals(currentItem)).count();
                        System.out.println("\t"+currentItem.getName() +"\t\tAmount:" +count);
                    }
                    break;
                case 2:
                    System.out.println("\n\tExiting the store.\n");
                    return;
                default:
                    System.out.println("\tInvalid choice. Please choose again.");
                    break;
            }
        } while (storeChoice != 2);
    }

    //in-store main menu
    private void displayStoreMenu() {
        System.out.println("\n\tStore Options:");
        System.out.println("\t(1) Purchase");
        System.out.println("\t(2) Leave");
        System.out.print("\n\t>>Enter your choice: ");
    }



    private void displayAvailableItems() {
        System.out.println("\n\tItem available\t: ");
        System.out.println("\t—-------------------------------------------------------------------------------------");
        System.out.println("\tName\t\t\tDescription\t\t\t\t\tCost");
        System.out.println("\t—-------------------------------------------------------------------------------------");
        for (Item item : availableItems) {
            System.out.println("\t" +item.getName() + "\t" +
                    item.getFunction() + "\t\t" +
                    item.getCost() + " Medals");
        }
        System.out.println("\t—-------------------------------------------------------------------------------------");

    }


    //method to purchase item
    private void purchaseItem() {
        displayAvailableItems(); // Method to display available items in the store
        System.out.print("\tEnter the number of the item you want to purchase: ");
        int selectedItemIndex = scanner.nextInt();

        // Adjusting for 0-based index when accessing the list
        int itemIndex = selectedItemIndex - 1;

        // Check if the entered index is within the range of available items
        if (itemIndex >= 0 && itemIndex < availableItems.size()) {
            Item selectedItem = availableItems.get(itemIndex);

            // Check if the player has enough medals to purchase the item
            if (player.getMedals() >= selectedItem.getCost()) {
                // Deduct the cost of the item from the player's medals
                player.setMedals(player.getMedals() - selectedItem.getCost());

                // Add the purchased item to the player's inventory
                player.addItemToInventory(selectedItem);

                System.out.println("\tYou have successfully purchased " + selectedItem.getName() + "!");
                System.out.println("\tRemaining Medals: " + player.getMedals());
            } else {
                System.out.println("\tInsufficient Medals to purchase this item.");
            }
        } else {
            System.out.println("\tInvalid item selection.");
        }
    }

    public void close() {
        scanner.close();
    }

    //main
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        game.close();
    }
}
