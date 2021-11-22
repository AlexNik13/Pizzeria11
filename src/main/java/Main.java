import ingredient.IngredientPizza;
import product.pizza.Pizza;
import product.pizza.SizePizza;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("Meat", SizePizza.XL, 150, 250,"Meat/chasse");

        System.out.println(pizza.getCost());
        pizza.addIngredientPizza(new IngredientPizza("Cыр пармезан",
                50,
                50));

        System.out.println(pizza.getCost());

    }
}
