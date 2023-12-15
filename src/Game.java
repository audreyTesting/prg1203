import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    //attributes
    private Player player;
    private List <Item> availableItems;
    private Scanner scanner;

    //empty constructor
    public Game() {
        player = new Player();
        availableItems = new ArrayList<>();
        initializeItems();
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
        System.out.println("Welcome to Catch and Battle.");
        System.out.println("A pokemon ball is generating…");
        System.out.println("TADAAA–! You got a GREAT-BALL");
        System.out.println("Catching pokemons . . .");
        System.out.println("3 pokemons had been caught!");

        System.out.println("\nTime to CHOOSE ONE!");
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
