public class Pokeball {
    private String name;
    private int catchrate;
    private int avail;

    //constructor
    public Pokeball(String n, int cr, int a) {
        setName(n);
        setCatchRate(cr);
        setAvail(a);
    }

    //setters and getters
    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setCatchRate(int cr) {
        if (cr > 0 && cr <= 4) {
            catchrate = cr;
        }
    }

    public int getCatchRate() {
        return catchrate;
    }

    public void setAvail(int a) {
        if (a > 0 && a <= 4) {
            avail = a;
        }
    }

    public int getAvail() {
        return avail;
    }

    //methods
    public void getRandomPokeball() {
        //get random pokeball based on catchrate

    }

    public void pokeballList() {
        //creating a list of pokeballs based on the randomly generated pokeballs
    }

    // toString method
    public String toString() {
        return String.format("%s: %d %d", getName(),getCatchRate(), getAvail());
    }
}
