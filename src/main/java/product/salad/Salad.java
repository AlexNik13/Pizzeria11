package product.salad;

import product.Product;
import product.TypeProduct;

public class Salad implements Product {
    private String name;
    private double cost;
    private String description;
    private TypeProduct typeProduct = TypeProduct.SALAD;

    public Salad(String name, double cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
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
        return null;
    }
}
