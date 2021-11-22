package ingredients;

public class Meat extends AbstractIngredients implements Ingredient {

    public Meat(int amountGram) {
        super("мясо", amountGram);
    }
}