package BD.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.SaveFile;
import ingredient.IngredientPizza;
import product.pizza.Pizza;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CatalogAdditivePizza {
    private ArrayList<IngredientPizza> ingredientPizza = new ArrayList<>();
    private final String fileName = "ingredientPizza.json";

    public CatalogAdditivePizza() {
       ingredientPizza = loadIngredientPizzaList(fileName);
    }

    public void printMenuIngredient(){
        for (int i = 0; i < ingredientPizza.size(); i++) {
            System.out.printf("%-3d: %s\n", (i+1), ingredientPizza.get(i).printFromMenu() );
        }
    }

    public IngredientPizza getIngredientPizza(int choiceIngredient){
        return ingredientPizza.get(choiceIngredient - 1).newIngredientPizza();
    }

    public void addNewIngredient(String name, int quantity, double price) {
        ingredientPizza.add(new IngredientPizza(name, quantity, price));
    }

    public void saveCatalogAdditivePizza() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(ingredientPizza);
        SaveFile.saveFile(fileName, strGson);
    }

    public ArrayList<IngredientPizza> getIngredientPizza() {
        return ingredientPizza;
    }

    private ArrayList<IngredientPizza> loadIngredientPizzaList(String fileName){
        ArrayList<IngredientPizza> ingredientPizzas;

        JsonReader jsonReader;
        Gson gson  = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/" + fileName)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));
            ingredientPizzas = gson.fromJson(jsonReader,
                    new TypeToken<ArrayList<IngredientPizza>>(){}.getType());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ingredientPizzas;
    }
}
