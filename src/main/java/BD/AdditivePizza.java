package BD;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.SaveFile;
import ingredient.IngredientPizza;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class AdditivePizza {
    private ArrayList<IngredientPizza> ingredientPizza = new ArrayList<>();
    private final String fileName = "productFood.json";

    public AdditivePizza() {
       ingredientPizza = loadProductFoodList(fileName);
    }

    public void addNewIngredient(String name, double price) {
        ingredientPizza.add(new IngredientPizza(name, price));
    }

    public void saveBD_ProductFood() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(ingredientPizza);
        SaveFile.saveFile(fileName, strGson);
    }

    public ArrayList<IngredientPizza> getProductFood() {
        return ingredientPizza;
    }

    private ArrayList<IngredientPizza> loadProductFoodList(String fileName){
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
