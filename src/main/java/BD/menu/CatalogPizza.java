package BD.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.SaveFile;
import ingredient.IngredientPizza;
import product.Product;
import product.pizza.Pizza;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CatalogPizza {
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private final String fileName = "pizza.json";

    public CatalogPizza() {
        pizzas = loadPizzaList(fileName);
    }

    public void addPizza(String name, double costSizeL, double costSizeXL, String description) {
        pizzas.add(new Pizza(name, costSizeL, costSizeXL, description));
    }

    public void saveCatalogPizza() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(pizzas);
        SaveFile.saveFile(fileName, strGson);
    }

    private ArrayList<Pizza> loadPizzaList(String fileName){
        ArrayList<Pizza> ingredientPizzas;

        JsonReader jsonReader;
        Gson gson  = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/" + fileName)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));
            ingredientPizzas = gson.fromJson(jsonReader,
                    new TypeToken<ArrayList<Pizza>>(){}.getType());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ingredientPizzas;
    }

    public void printMenuPizza(){
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.printf("%-3d: %s\n", (i+1), pizzas.get(i).printFromMenu() );
        }
    }

    public Pizza getNewPizzaSizeL(int choicePizza){
        return pizzas.get(choicePizza - 1).newPizzaSizeL();
    }

    public Pizza getNewPizzaSizeXL(int choicePizza){
        return pizzas.get(choicePizza - 1).newPizzaSizeXL();
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
}
