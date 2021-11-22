package ingredients;

public abstract class AbstractIngredients {
    private String name;
    private double price;
    private int amountGram;
    private double cost;

    public AbstractIngredients(String name, int amountGram) {
        this.name = name;
        this.amountGram = amountGram;
        countCost();
    }

    private void countCost(){
        cost = price / 1000 * amountGram;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amountGram;
    }

    public double getCost() {
        return cost;
    }
}
