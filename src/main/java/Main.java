import BD.BD_ProductFood;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import ingredient.ProductFood;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BD_ProductFood food = new BD_ProductFood();

/*     food.addNewIngredient("Meat", 135);
        food.addNewIngredient("Помидорки", 20);
        food.addNewIngredient("Сыр", 250);
        food.addNewIngredient("Колбаска", 500);


       food.saveBD_ProductFood();*/

     /*   Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String wayFile = "src/main/java/BD/file/productFood.json";
        try (FileInputStream fileInputStream = new FileInputStream(wayFile)) {

            JsonReader jsonReader = new JsonReader(new InputStreamReader(fileInputStream));

            food = gson.fromJson(jsonReader, BD_ProductFood.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        System.out.println(food.getProductFood());
/*
        for (ProductFood productFood : food.getProductFood()) {
            productFood.toString();
        }*/

    }
}
