import customer.Customer;
import ingredient.IngredientPizza;
import product.Product;
import product.pizza.Pizza;
import product.pizza.SizePizza;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

       products = new Customer().buyPizza();

        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getCost());
        }
    }
}
