package customer;

import menu.MenuBuyPizza;
import product.Product;
import product.pizza.Pizza;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> buyPizza() {
        ArrayList<Product> productPizza = new ArrayList<>();
        Pizza pizza = null;
        do {
            pizza = new MenuBuyPizza().buyPizzaMenu();
            if (pizza != null) {
                productPizza.add(pizza);
            }
        } while (pizza != null);
        return productPizza;
    }
}
