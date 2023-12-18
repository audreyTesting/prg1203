import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Game {

    //attributes
    private Player player;
    private List <Item> availableItems;
    private List<Pokeball> balls = new ArrayList<>();
    private List<GrassPokemon> grassPokemon = new ArrayList<>();
    private List<FirePokemon> firePokemon= new ArrayList<>();
    private List<WaterPokemon> waterPokemon= new ArrayList<>();
    private Scanner scanner;

    //empty constructor
    public Game() {
        player = new Player();
        availableItems = new ArrayList<>();
        balls = new ArrayList<>();
        firePokemon = new ArrayList<>();
        waterPokemon = new ArrayList<>();
        grassPokemon = new ArrayList<>();
        pokeballList();
        initializeItems();
        pokemonsList();
        scanner = new Scanner(System.in);
    }

    //methods

    //starting the game
    public void start() {
        System.out.println("\n");
        System.out.println("—---------! WELCOME TO POKEMON GA OLE! —----------");
        System.out.print("Please enter your name to start: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);
        System.out.println("\nHello " + playerName + ",\n");

        int choice;
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    catchAndBattle();
                    break;
                case 2:
                    displayPokemons();
                    break;
                case 3:
                    displayStore();
                    break;
                case 4:
                    System.out.println("Exiting the game. See you again!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } while (choice != 4);
    }




    // printing main menu
    private void displayMainMenu() {
        System.out.println("Select:");
        System.out.println("(1) Catch and Battle");
        System.out.println("(2) Pokemons");
        System.out.println("(3) Stores");
        System.out.println("(4) Quit");
        System.out.print("Enter your choice: ");
    }



    //catch and battle mode
    private void catchAndBattle() {
        System.out.println("\nWelcome to Catch and Battle.");
        System.out.println("\nA pokemon ball is generating…");
        Pokeball randomPokeball = generateRandomPokeball();

        System.out.println("TADAAA–! You got a "+ randomPokeball.getName());
        System.out.println("\nCatching pokemons . . .");
        System.out.println("3 pokemons had been caught!");

        List <Pokemon> userPokemonChoices = gnrRandPokemonList();
        System.out.println("\nTime to CHOOSE ONE!");
        int count = 1;
        for (Pokemon pokemon: userPokemonChoices) {
            System.out.println("[" + count+ "] " + pokemon.getName() + " - Type: " + pokemon.getType());
            count++;
        }
        displayPokemons();
        // Display available pokemon options for selection
        // Implement logic for choosing and battling a pokemon
    }


    //adding items list
    private void initializeItems() {
        availableItems.add(new Item("[1] Attack Capsule",	"Providint a attack boost in battle",		30));
        availableItems.add(new Item("[2] Defense Capsule",	"Provides defense boost during defense",	30));
        availableItems.add(new Item("[3] Quicker Drink",	"Speed up attack move during attack",		30));
        availableItems.add(new Item("[4] Aim BoostScope",		"Increase the chance of critical hit",		30));
        availableItems.add(new Item("[5] Support Pokemon",	"Unlocks a new Support pokemon in battle", 	30));
        availableItems.add(new Item("[6] Spirit Drink",		"Increase player's starting FP by 100%",	30));
    }

    //pokeball list
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

    private Pokeball generateRandomPokeball() {
        if (balls.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(balls.size()); // Get a random index within the list size
        return balls.get(randomIndex); // Return the Pokeball at the random index
    }

    //adding pokemons list
    private void pokemonsList() {
        //fire type
        FirePokemon fire1 = new FirePokemon(244,"Entei",1,115,115,85,100,"Pressure,Flash Fire");
        FirePokemon fire2 = new FirePokemon(555,"Darmaniltan",1,105,140,55,95,"Sheer Force, Zen Mode");
        FirePokemon fire3 = new FirePokemon(631,"Heatmor",1,85,97,66,65,"Gluttony, Flash Fire, White Smoke");
        FirePokemon fire4 = new FirePokemon(157,"Typhlosion",1,78,84,78,100,"Blaze, Flash Fire");
        firePokemon.add(fire1);
        firePokemon.add(fire2);
        firePokemon.add(fire3);
        firePokemon.add(fire4);

        //water type
        WaterPokemon water1 = new WaterPokemon(245,"Suicune",1,100,75,115,85,"Pressure, Water Absorb");
        WaterPokemon water2 = new WaterPokemon(382,"Kyogre",1,100,150,90,90,"Pimordial Sea");
        WaterPokemon water3 = new WaterPokemon(503,"Samurott",1,95,100,85,70,"Torrent, Shell Armor");
        WaterPokemon water4 = new WaterPokemon(186,"Politoed",1,90,75,75,70,"Water Absorb Damp Drizzle");
        waterPokemon.add(water1);
        waterPokemon.add(water2);
        waterPokemon.add(water3);
        waterPokemon.add(water4);

        //grass type
        GrassPokemon grass1 = new GrassPokemon(492,"Shaymin",1,100,100,100,100,"Natural Cure");
        GrassPokemon grass2 = new GrassPokemon(154,"Meganium",1,80,82,100,80,"Overgrow, leafguard");
        GrassPokemon grass3 = new GrassPokemon(182,"Bellossom",1,75,80,95,50,"Chlorophyll, Healer");
        GrassPokemon grass4 = new GrassPokemon(388,"Grotle",1,75,89,85,36,"Overgrow, Shell Armor");
        grassPokemon.add(grass1);
        grassPokemon.add(grass2);
        grassPokemon.add(grass3);
        grassPokemon.add(grass4);
    }

    //random pokemon from each type
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
        List<Pokemon> pokemons = player.getPokemons(); // Assuming getPlayer() returns the player instance
        if (pokemons.isEmpty()) {
            System.out.println("No pokemons yet!\n");
        } else {
            System.out.println("\nHere are your pokemons:");
            for (Pokemon pokemon : pokemons) {
                System.out.println(pokemon.toString()); // Assuming toString() in Pokemon class provides the details
            }
        }
    }



    //displaying stores and inventory
    private void displayStore() {
        System.out.println("\nWelcome to the Poke Store!");
        System.out.println("Medals: " + player.getMedals());
        System.out.println("Your Inventory:");
        player.getInventory();
        System.out.println("\nItem available: ");
        System.out.println("—---------------------------------------------------------------------------------------------");
        System.out.println("Name\t\t\t\tDescription\t\t\t\t\tCost");
        System.out.println("—---------------------------------------------------------------------------------------------");
        for (Item item : availableItems) {
            System.out.println(item.getName() + "\t\t" +
                    item.getFunction() + "\t\t" +
                    item.getCost() + " Medals");
        }
        System.out.println("—---------------------------------------------------------------------------------------------");

        int storeChoice;
        do {
            displayStoreMenu();
            storeChoice = scanner.nextInt();
            switch(storeChoice) {
                case 1:
                    purchaseItem();
                    break;
                case 2:
                    System.out.println("Exiting the store.\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }while(storeChoice != 2);
    }

    //main menu for store
    private void displayStoreMenu() {
        System.out.println("\nStore Options:");
        System.out.println("(1) Purchase");
        System.out.println("(2) Leave");
        System.out.print("Enter your choice: ");
    }


    //method to purchase item
    private void purchaseItem() {


    }


    public void close() {
        // Close any resources (e.g., scanner) when the game ends
        scanner.close();
    }

    //main
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        game.close();
    }
}
