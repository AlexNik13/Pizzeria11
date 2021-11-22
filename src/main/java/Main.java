import product.pizza.Pizza;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("Meat",100, 150, "Meat/chasse");

        System.out.println(pizza.toString());
        pizza.printFromMenu();
    }
}
