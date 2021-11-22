package ingredient;

import java.util.Formatter;

public class IngredientPizza implements Cloneable{
    private String name;
    private int quantity;
    private double price;

    public IngredientPizza(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public IngredientPizza newIngredientPizza(){
        return new IngredientPizza(name, quantity,price );
    }

    public String printFromMenu(){
        Formatter formatter = new Formatter();
        formatter.format(" %-20s %-3d грам. %6.2f грн", name, quantity, price);
        return formatter.toString();
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductFood{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
