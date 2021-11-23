package menu;

import BD.menu.CatalogAdditivePizza;
import helper.Input;
import ingredient.IngredientPizza;

import java.util.ArrayList;

public class MenuAddIngredient {


    public ArrayList<IngredientPizza> addIngredient() {
        ArrayList<IngredientPizza> ingredientPizzas = new ArrayList<>();
        CatalogAdditivePizza catalogAdditivePizza = new CatalogAdditivePizza();
        boolean menu = true;

        while (menu) {
            System.out.println("Выберите ингредиенты");
            catalogAdditivePizza.printMenuIngredient();

            int choice = Input.nextInt();

            if (choice != 0) {
                ingredientPizzas.add(catalogAdditivePizza.getIngredientPizza(choice));
            } else {
                menu = false;
            }
        }
        return ingredientPizzas;
    }
}
