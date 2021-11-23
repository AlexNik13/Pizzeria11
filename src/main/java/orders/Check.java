package orders;

import customer.Customer;
import product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;

public class Check {
    private ArrayList<Product> products = new ArrayList<>();
    private LocalDateTime date;
    private final String numberCheck = LocalDateTime.now().toString().substring(0, 19);
    private double totalCost;

    public Check() {
        this.products = new Customer().buyPizza();
        countTotalCost();
    }

    public void printBriefCheck(){
        System.out.println("Чек N: " + numberCheck);

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%-3d: %7s - %s\n\t%.2f\n",
                    i,
                    products.get(i).getTypeProduct(),
                    products.get(i).getName(),
                    products.get(i).getCost());
        }
    }

    private void countTotalCost(){
        totalCost = 0;
        for (Product product : products) {
            totalCost += product.getCost();
        }
    }

}
