package menu;

import BD.menu.CatalogAdditivePizza;
import BD.menu.CatalogPizza;
import BD.menu.CatalogSalad;
import helper.Input;
import orders.Orders;

public class TopMenu {
    private Orders orders = new Orders();

    public void start() {
        boolean menu = true;
        while (menu) {
            System.out.println("1  : Новый клиент");
            System.out.println("2  : Истоия продаж");
            System.out.println("3  : Добавить новую пиццу");
            System.out.println("4  : Добавить новый салат  ");
            System.out.println("5  : Добавить новый ингредиенты для пиццы ");

            System.out.println("0  : Выход ");
            int choice = Input.nextInt();
            switch (choice) {
                case 0:
                    orders.saveOrders();
                    menu = false;
                    break;
                case 1:
                    orders.addNewCheckFromClient();
                    break;
                case 2:
                    orders.printHistoryCheck();
                    break;
                case 3:
                    new CatalogPizza().addNewCatalogItem();
                    break;
                case 4:
                    new CatalogSalad().addNewCatalogItem();
                    break;
                case 5:
                    new CatalogAdditivePizza().addNewCatalogItem();
                    break;
            }
        }
    }
}
