package menu;

import BD.menu.CatalogPizza;
import helper.Input;
import orders.Orders;

public class TopMenu {

    private Orders orders = new Orders();

    public void mainMenu(){

    }

    public void start(){
        boolean menu = true;
        while (menu){
            System.out.println("1  : Новый клиент");
            System.out.println("2  : Истоия продаж");
            System.out.println("3  : Добавить новую пиццу");



            int choice = Input.nextInt();
            switch (choice){
                case 1:
                    orders.addNewCheckFromClient();
                    break;
                case 2:
                    System.out.println("SORRY DO NOT WORK");
                    break;

                case 3:
                    new CatalogPizza().addNewPizza();
                    break;
            }
        }

    }
}
