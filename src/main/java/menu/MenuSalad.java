package menu;

import BD.menu.CatalogSalad;
import helper.Input;
import product.Product;
import product.pizza.Pizza;
import product.pizza.ingredient.IngredientPizza;
import product.salad.Salad;

import java.util.ArrayList;

public class MenuSalad {
    private CatalogSalad saladCatalog = new CatalogSalad();

    public ArrayList<Product> start(){
        ArrayList<Product> products = new ArrayList<>();
        Salad salad = null;
        do {
            salad = buySalad();
            if(salad != null){
                products.add(salad);
            }
        }while (salad != null);
        return products;
    }

    public Salad buySalad() {
        boolean menu = true;
        Salad salad = null;
        System.out.println("Выберети салат .");
        saladCatalog.printMenuCatalogItem();
        System.out.printf("0  : Вернуться.\n");
        System.out.printf("Сделайте выбор:\n");
        int choice = Input.nextInt();
        if (choice == 0) {
            menu = false;
        } else {
            salad = saladCatalog.cloneItem(new Salad(), choice);
            return salad;
        }
        return null;
    }

}
