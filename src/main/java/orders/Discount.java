package orders;

import helper.Input;

import java.util.ArrayList;

public class Discount {
    private ArrayList<Customer> customers = new ArrayList<>();

    public Discount() {
    }

    public void addCustomer(){

    }

    public void addNewCustomer(){
        System.out.print("Введите имя клиента: ");
        String name = Input.nextSting();
        System.out.print("Телефон клиента (063-369-25-14): ");
        String phone = Input.nextSting();
    }

    public boolean isDiscount(String phone){
        String phoneNumber = "";
        for (char ch : phone.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                phoneNumber += ch;
            }
        }
        if(phoneNumber.length() < 10){
            System.out.println("Не провальный номер.  ");
            System.out.print("Введите корректный номер :");
            return isDiscount(Input.nextSting());
        }
        for (Customer customer : customers) {

            if (customer.getPhone().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
