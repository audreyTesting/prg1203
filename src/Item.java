
public class Item {

    //attributes
    private String name;
    private String function;
    private int cost;

    //empty constructors
    public Item() {

    }

    //complete constructors
    public Item(String name, String function, int cost) {
        this.name = name;
        this.function = function;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFunction() {
        return function;
    }
    public void setFunction(String function) {
        this.function = function;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }




}
