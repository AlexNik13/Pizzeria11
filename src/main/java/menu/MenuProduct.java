package menu;

import helper.Input;
import product.Product;

import java.util.ArrayList;

public class MenuProduct {


    public ArrayList<Product> start(){
        ArrayList<Product> products = new ArrayList<>();
        boolean menu = true;
        while (menu){
            System.out.println("1  : Заказать пиццу. ");
            System.out.println("2  : Заказать салат.  ");
            System.out.println("0  : Посчитать.  ");
            int choice = Input.nextInt();
            switch (choice){
                case 0:
                    menu = false;
                    break;
                case 1:
                    products.addAll(new MenuPizza().start());
                    break;
                case 2:
                    products.addAll(new MenuSalad().start());
                    break;
            }
        }

        return products;
    }
}
