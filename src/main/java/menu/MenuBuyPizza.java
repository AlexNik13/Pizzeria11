package menu;

import BD.menu.CatalogPizza;
import helper.Input;
import ingredient.IngredientPizza;
import product.Product;
import product.pizza.Pizza;

import java.util.ArrayList;

public class MenuBuyPizza {
    private CatalogPizza catalogPizza = new CatalogPizza();

    public Pizza buyPizzaMenu() {
        boolean menu = true;
        Pizza pizza = null;

            System.out.println("Выберети пиццу.");
            catalogPizza.printMenuPizza();
            System.out.printf("0  : Посчитать.\n");
            System.out.printf("Сделайте выбор:\n");

            int choice = Input.nextInt();

            if (choice == 0) {
                menu = false;
            } else {
                System.out.printf("Размер \n1  :X  \n2  :XL\n");
                int size = Input.nextInt();
                if (size == 2) {
                    return buyPizzaXL(choice);
                } else {
                    return buyPizzaL(choice);
                }
            }

        return null;
    }

    private Pizza buyPizzaL(int choicePizza) {
        Pizza pizza = catalogPizza.getNewPizzaSizeL(choicePizza);
        ArrayList<IngredientPizza> ingredientPizzas = new ArrayList<>();
        System.out.println("Добавить добавки? \n1  :Да \n0  : Нет");

        int choice = Input.nextInt();
        if(choice != 0){
            ingredientPizzas = new MenuAddIngredient().addIngredient();
            pizza.addListIngredientPizza(ingredientPizzas);
        }

        return pizza;
    }

    private Pizza buyPizzaXL(int choicePizza) {
        Pizza pizza =  catalogPizza.getNewPizzaSizeXL(choicePizza);
        return pizza;
    }
}
