package pizza;


import ingredients.Ingredient;

import java.util.ArrayList;

public abstract class AbstractPizza {
    private String name;
    private SizePizza sizePizza;
    private double cost;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();


    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

}
