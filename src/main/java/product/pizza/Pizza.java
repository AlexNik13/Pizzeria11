package product.pizza;

import ingredient.IngredientPizza;
import product.Product;
import product.TypeProduct;
import java.util.ArrayList;
import java.util.Formatter;

public class Pizza implements Product {
    private String name;
    private SizePizza sizePizza;
    private double costIngredient = 0;
    private double costSizeL;
    private double costSizeXL;
    private String description;
    private ArrayList<IngredientPizza> ingredientPizzas = new ArrayList<>();
    private final TypeProduct typeProduct = TypeProduct.PIZZA;

    public Pizza() {
    }

    public Pizza(String name, double costSizeL, double costSizeXL, String description) {
        this.name = name;
        this.costSizeL = costSizeL;
        this.costSizeXL = costSizeXL;
        this.description = description;
    }

    public Pizza(String name, SizePizza sizePizza, double costSizeL, double costSizeXL, String description) {
        this.name = name;
        this.sizePizza = sizePizza;
        this.costSizeL = costSizeL;
        this.costSizeXL = costSizeXL;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", sizePizza=" + sizePizza +
                ", costSizeL=" + costSizeL +
                ", costSizeXL=" + costSizeXL +
                ", description='" + description + '\'' +
                ", ingredientPizzas=" + ingredientPizzas +
                '}';
    }

    public Pizza getClonePizzaSizeL() {
        return new Pizza(name, SizePizza.L, costSizeL, costSizeXL, description);
    }

    public Pizza getClonePizzaSizeXL() {
        return new Pizza(name, sizePizza.XL, costSizeL, costSizeXL, description);
    }

    public void addIngredient(ArrayList<IngredientPizza> ingredientPizzas) {
        name = name + " *";
        this.ingredientPizzas.addAll(ingredientPizzas);
    }

    public String printFromMenu() {
        Formatter formatter = new Formatter();
        formatter.format("%-13s\n%s\nРазмер X\\Xl. Цена  %-6.2f \\ %-6.2f грн\n",
                name, description, costSizeL, costSizeXL);
        return formatter.toString();
    }

    @Override
    public String getName() {
        return name + " " + sizePizza;
    }

    public SizePizza getSizePizza() {
        return sizePizza;
    }

    @Override
    public double getCost() {
        costIngredient = 0;
        for (IngredientPizza ingredientPizza : ingredientPizzas) {
            costIngredient += ingredientPizza.getCost();
        }

        if (sizePizza == SizePizza.L) {
            return costSizeL + costIngredient;
        }
        if (sizePizza == SizePizza.XL) {
            return costSizeXL + costIngredient;
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public ArrayList<IngredientPizza> getIngredientPizzas() {
        return ingredientPizzas;
    }
}
