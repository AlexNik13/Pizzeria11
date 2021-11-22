package product.pizza;


import ingredient.IngredientPizza;
import product.Product;

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

    public Pizza newPizzaSizeL() {
        return new Pizza(name, SizePizza.L, costSizeL, costSizeXL, description);
    }

    public Pizza newPizzaSizeXL() {
        return new Pizza(name, sizePizza.XL, costSizeL, costSizeXL, description);
    }


    public void addListIngredientPizza(ArrayList<IngredientPizza> ingredientPizzas) {

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
        return name;
    }

    public SizePizza getSizePizza() {
        return sizePizza;
    }

    @Override
    public double getCost() {
        costIngredient = 0;
        for (IngredientPizza ingredientPizza : ingredientPizzas) {
            costIngredient = +ingredientPizza.getPrice();
        }

        if (sizePizza == SizePizza.L) {
            return costSizeL + costIngredient;
        }
        if (sizePizza == SizePizza.XL) {
            return costSizeXL + costIngredient;
        }

        return 0;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<IngredientPizza> getProductFoods() {
        return ingredientPizzas;
    }
}
