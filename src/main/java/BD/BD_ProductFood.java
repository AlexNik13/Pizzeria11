package BD;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.SaveFile;
import ingredient.ProductFood;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;



public class BD_ProductFood {
    private ArrayList<ProductFood> productFood = new ArrayList<>();
    private final String fileName = "productFood.json";

    public BD_ProductFood() {
       productFood = loadProductFoodList(fileName);
    }

    public void addNewIngredient(String name, double price) {
        productFood.add(new ProductFood(name, price));
    }

    public void saveBD_ProductFood() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(productFood);
        SaveFile.saveFile(fileName, strGson);
    }



    public ArrayList<ProductFood> getProductFood() {
        return productFood;
    }

    private ArrayList<ProductFood> loadProductFoodList(String fileName){
        ArrayList<ProductFood> productFoods;

        JsonReader jsonReader;
        Gson gson  = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/" + fileName)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));
            productFoods = gson.fromJson(jsonReader,
                    new TypeToken<ArrayList<ProductFood>>(){}.getType());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productFoods;
    }



}
