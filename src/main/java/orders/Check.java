package orders;

import menu.MenuProduct;
import product.Product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Check implements Serializable {
    private ArrayList<Product> products = new ArrayList<>();
    private String numberCheck = LocalDateTime.now().toString().substring(0, 19);
    private double totalCost;

    public Check start(){
        this.products = new MenuProduct().start();
        countTotalCost();
        printBriefCheck();
        return this;
    }

    public void printBriefCheck(){
        System.out.println("Чек N: " + numberCheck);
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%-3d: %7s - %s\n\t%.2f\n",
                    (i + 1),
                    products.get(i).getTypeProduct(),
                    products.get(i).getName(),
                    products.get(i).getCost());
        }
        System.out.printf("\t\tИтого: %.2f\n", totalCost );
    }

    private void countTotalCost(){
        totalCost = 0;
        for (Product product : products) {
            totalCost += product.getCost();
        }
    }

    public String getNumberCheck() {
        return numberCheck;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
