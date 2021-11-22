package ingredients;

public class Sauce extends AbstractIngredients implements Ingredient {

    public Sauce(int amountGram) {
        super("соус", amountGram);
    }
}