package ingredient;

public class IngredientPizza implements Cloneable{
    private String name;
    private int quantity;
    private double price;

    public IngredientPizza(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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
