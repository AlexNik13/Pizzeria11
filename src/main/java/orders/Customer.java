package orders;

import helper.Input;

public class Customer {
    private String name;
    private String phone;
    private int discountSize;

    public Customer() {
    }

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.discountSize = 5;
    }

    public void setPhone(String phone) {
        String phoneNumber = "";
        for (char ch : phone.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                phoneNumber += ch;
            }
        }
        if(phoneNumber.length() < 10){
            System.out.println("Не провальный номер.  ");
            System.out.print("Введите корректный номер :");
            setPhone(Input.nextSting());
        }else {
            this.phone = phoneNumber.substring(phoneNumber.length() -10);
        }
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getDiscountSize() {
        return discountSize;
    }
}
