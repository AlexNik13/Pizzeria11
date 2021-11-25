package menu;

import BD.menu.CatalogPizza;
import helper.Input;
import product.pizza.ingredient.IngredientPizza;
import product.pizza.Pizza;

import java.util.ArrayList;

public class MenuBuyPizza {
    private CatalogPizza catalogPizza = new CatalogPizza();

    public Pizza buyPizzaMenu() {
        boolean menu = true;
        Pizza pizza = null;

        System.out.println("Выберети пиццу.");
        catalogPizza.printMenuCatalogItem();
        System.out.printf("0  : Посчитать.\n");
        System.out.printf("Сделайте выбор:\n");
        int choice = Input.nextInt();
        if (choice == 0) {
            menu = false;
        } else {
            pizza = catalogPizza.cloneItem(new Pizza(), choice);
            if (isWantAddIngredientPizzas()) {
                pizza.addIngredient(addIngredientPizzas());
            }

            return pizza;
        }
        return null;
    }

    private ArrayList<IngredientPizza> addIngredientPizzas() {
        ArrayList<IngredientPizza> ingredientPizzas = new ArrayList<>();
        ingredientPizzas = new MenuAddIngredient().addIngredient();
        return ingredientPizzas;
    }

    private boolean isWantAddIngredientPizzas() {
        System.out.println("Добавить добавки? \n1  : Да \n0  : Нет");
        int choice = Input.nextInt();
        if (choice != 0) {
            return true;
        }
        return false;
    }

}
