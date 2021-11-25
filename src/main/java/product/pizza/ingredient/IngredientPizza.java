package product.pizza.ingredient;

import java.util.Formatter;

public class IngredientPizza  {
    private String name;
    private int quantity;
    private double cost;

    public IngredientPizza() {
    }

    public IngredientPizza(String name, int quantity, double cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public IngredientPizza getClone() {
        return new IngredientPizza(name, quantity, cost);
    }

    public String printFromMenu() {
        Formatter formatter = new Formatter();
        formatter.format(" %-20s %-3d грам. %6.2f грн", name, quantity, cost);
        return formatter.toString();
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "ProductFood{" +
                "name='" + name + '\'' +
                ", price=" + cost +
                '}';
    }
}
