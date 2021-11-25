package menu;

import helper.Input;
import orders.Check;
import orders.Discount;
import product.Product;

import java.util.ArrayList;

public class MenuDiscount {


    public Check start(){

        System.out.println("1  : Клиент без скидки.");
        System.out.println("2  : Клиент со скидкой.");
        System.out.println("3  : Оформить клиенту скидку. .");
        int choice = Input.nextInt();

        switch (choice){
            case 1:
                return new Check().start();
            case 2:
                System.out.print("Введите номер телефона клиента: ");
                String phone = Input.phoneNumber();
                return new Check(new Discount().isExistsCustomerDiscount(phone)).start();

            case 3:
                new Discount().addNewCustomer();
                return new Check(true).start();
        }

        return new Check().start();
    }
}
