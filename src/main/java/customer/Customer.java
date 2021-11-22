package customer;

import BD.menu.CatalogPizza;
import helper.Input;
import product.Product;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Product> products = new ArrayList<>();
    private CatalogPizza catalogPizza = new CatalogPizza();



    public ArrayList<Product> buyPizzaMenu(){
        boolean menu = true;
        while (menu){
            System.out.println("Выберети пиццу.");
            catalogPizza.printMenuPizza();
            System.out.printf("0  : Посчитать.\n");
            System.out.printf("Сделайте выбор:\n");

            int choice = Input.nextInt();


            if(choice == 0){
                menu = false;
            }else {
                System.out.printf("Размер \n1  :X  \n2  :XL\n");
                int size = Input.nextInt();
                if(size == 2){
                    buyPizzaXL(choice);
                }else {
                    buyPizzaL(choice);
                }
            }
        }

        return products;
    }

    private void buyPizzaL(int choicePizza){
        products.add(catalogPizza.getNewPizzaSizeL(choicePizza));
    }

    private void buyPizzaXL(int choicePizza){
        products.add(catalogPizza.getNewPizzaSizeXL(choicePizza));
    }
}
