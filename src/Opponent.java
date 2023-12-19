public class Opponent {
    private String name;

    public Opponent(String name) {
        this.name = name;
    }

    public void autoChoosePokemon() {
        Pokemon selectedPokemon = sendOutPokemon();

        if (selectedPokemon != null) {
            System.out.println(getName() + " sends out " + selectedPokemon.getName() + "!");
        } else {
            System.out.println(getName() + " has no Pokemon to send out.");
        }
    }

    public Pokemon sendOutPokemon() {
        return null;
    }

    public String getName() {
        return this.name;
    }
}

