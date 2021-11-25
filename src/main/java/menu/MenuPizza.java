package menu;

import BD.menu.CatalogPizza;
import helper.Input;
import product.Product;
import product.pizza.ingredient.IngredientPizza;
import product.pizza.Pizza;

import java.util.ArrayList;

public class MenuPizza {
    private CatalogPizza catalogPizza = new CatalogPizza();

    public ArrayList<Product> start(){
        ArrayList<Product> products = new ArrayList<>();
        Pizza pizza = null;
        do {
            pizza = buyPizzaMenu();
            if(pizza != null){
                products.add(pizza);
            }
        }while (pizza != null);
        return products;
    }

    public Pizza buyPizzaMenu() {
        Pizza pizza = null;
        System.out.println("Выберети пиццу.");
        catalogPizza.printMenuCatalogItem();
        System.out.printf("0  : Вернуться.\n");
        System.out.printf("Сделайте выбор:\n");
        int choice = Input.nextInt();
        if (choice != 0) {
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
