package orders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import helper.Input;
import helper.SaveFile;
import product.salad.Salad;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Discount {
    private ArrayList<Customer> customers = new ArrayList<>();
    private final String fileName = "discount.json";

    public Discount() {
        customers = loadCustomer(fileName);
    }

    public void saveDiscount() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(customers);
        SaveFile.saveFile(fileName, strGson);
    }

    private ArrayList<Customer> loadCustomer(String fileName) {
        ArrayList<Customer> customers;
        JsonReader jsonReader;
        Gson gson = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/" + fileName)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));
            customers = gson.fromJson(jsonReader,
                    new TypeToken<ArrayList<Customer>>() {
                    }.getType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public void addCustomer(String name, String phone){
        customers.add(new Customer(name, phone));
    }

    public void addNewCustomer(){
        System.out.print("Введите имя клиента: ");
        String name = Input.nextSting();
        System.out.print("Телефон клиента (063-369-25-14): ");
        String phone = Input.nextSting();
        customers.add(new Customer(name, phone));
        saveDiscount();
    }

    public boolean  isExistsCustomerDiscount(String phone){
        String phoneNumber = "";
        for (char ch : phone.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                phoneNumber += ch;
            }
        }
        if(phoneNumber.length() < 10){
            System.out.println("Не провальный номер.  ");
            System.out.print("Введите корректный номер :");
            return isExistsCustomerDiscount(Input.nextSting());
        }

        for (Customer customer : customers) {

            if (customer.getPhone().equals(phoneNumber.substring(phoneNumber.length()-10))) {
                return true;
            }
        }
        return false;
    }
}
