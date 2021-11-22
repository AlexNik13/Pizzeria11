package BD.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.SaveFile;
import product.pizza.Pizza;

import java.util.ArrayList;

public class CatalogPizza {
    private ArrayList<Pizza> pizzas;
    private final String fileName = "pizza.json";

    public CatalogPizza() {

    }

    public void addPizza(String name, double costSizeL, double costSizeXL, String description) {
        pizzas.add(new Pizza(name, costSizeL, costSizeXL, description));
    }

    public void saveCatalogAdditivePizza() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(pizzas);
        SaveFile.saveFile(fileName, strGson);
    }

}
