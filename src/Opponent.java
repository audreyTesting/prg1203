public class Opponent {
    private Pokemon pokemon;

    public Opponent(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getOpponentPokemon() {
        return pokemon;
    }

    public String getName() {
        return pokemon.getName(); // You might have a separate name attribute for the opponent
    }
}
