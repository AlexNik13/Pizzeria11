package orders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import helper.SaveFile;
import product.pizza.Pizza;


import java.io.*;
import java.util.ArrayList;

public class Orders {
    private ArrayList<Check> checks = new ArrayList<>();
    private final String fileName = "orders.json";

    public Orders() {
         //TODO Do not work
        //     this.checks = loadCheckList(fileName);
    }

    public void addNewCheckFromClient() {
        checks.add(new Check().start());
    }

    public void saveCatalogPizza() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(checks);
        SaveFile.saveFile(fileName, strGson);
    }

    public void printHistoryCheck() {
        for (Check check : checks) {
            System.out.printf("№: %25s - сумма: %.2f\n", check.getNumberCheck(), check.getTotalCost());
        }
    }

    //TODO not work
    private ArrayList<Check> loadCheckList(String fileName) {
        ArrayList<Check> ingredientPizzas;
        JsonReader jsonReader;
        Gson gson = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/" + fileName)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));
            ingredientPizzas = gson.fromJson(jsonReader,
                    new TypeToken<ArrayList<Check>>() {
                    }.getType());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ingredientPizzas;
    }
}
