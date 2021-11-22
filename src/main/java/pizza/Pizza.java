package pizza;


import ingredient.IngredientPizza;

import java.util.ArrayList;

public class Pizza {
    private String name;
    private SizePizza sizePizza;
    private double costSizeL;
    private double costSizeXL;
    private String description;
    private ArrayList<IngredientPizza> ingredientPizzas = new ArrayList<>();

    public Pizza(String name, SizePizza sizePizza, double costSizeL, double costSizeXL, String description) {
        this.name = name;
        this.sizePizza = sizePizza;
        this.costSizeL = costSizeL;
        this.costSizeXL = costSizeXL;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public SizePizza getSizePizza() {
        return sizePizza;
    }

    public double getCostSizeL() {
        return costSizeL;
    }

    public double getCostSizeXL() {
        return costSizeXL;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<IngredientPizza> getProductFoods() {
        return ingredientPizzas;
    }
}
