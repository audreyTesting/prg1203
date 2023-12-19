public class WaterPokemon extends Pokemon {

    // Constructor
    public WaterPokemon(int index, String name, int level, int hp, int defense, int attack, int speed, String ability) {
        super(index, name, level, "Water", hp, defense, attack, speed, ability);
    }

    // Override toString method
    @Override
    public String toString() {
        return String.format(
                "\n\tIndex\t: %d\n\tName\t: %s\n\tLevel\t: %d\n\tType\t: %s\n\tHP\t: %d\n\tDefense\t: %d\n\tAttack\t: %d\n\tSpeed\t: %d\n\tAbility\t: %s",
                getIndex(), getName(), getLevel(), getType(), getHp(), getDefense(), getAttack(), getSpeed(), getAbility()
        );
    }
}
