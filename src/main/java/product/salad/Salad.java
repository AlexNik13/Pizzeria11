package product.salad;

import product.Product;
import product.TypeProduct;
import product.pizza.ingredient.IngredientPizza;

import java.util.Formatter;

public class Salad implements Product {
    private String name;
    private String description;
    private double cost;
    private TypeProduct typeProduct = TypeProduct.SALAD;

    public Salad() {
    }

    public Salad(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public Salad getClone() {
        return new Salad(name, description, cost);
    }

    @Override
    public String toString() {
        return "Salad{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", typeProduct=" + typeProduct +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public String printFromMenu() {
        Formatter formatter = new Formatter();
        formatter.format(" %-30s  %6.2f грн", name, cost);
        return formatter.toString();
    }
}
