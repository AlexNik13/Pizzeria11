package BD.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import helper.Input;
import helper.SaveFile;
import product.pizza.Pizza;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CatalogPizza implements CatalogItem {
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private final String fileName = "pizza.json";

    public CatalogPizza() {
        pizzas = loadCatalogPizza(fileName);
    }

    @Override
    public void addNewCatalogItem() {
        System.out.print("Ведите название пиццы: ");
        String name = Input.nextSting();
        System.out.print("Ведите состав пиццы: ");
        String description = Input.nextSting();
        System.out.print("Ведите цену стандартной пиццы: ");
        double costSizeL = Input.nextDouble();
        System.out.print("Ведите цену большой пиццы: ");
        double costSizeXL = Input.nextDouble();
        pizzas.add(new Pizza(name, costSizeL, costSizeXL, description));
        saveCatalogItem();
    }

    @Override
    public void saveCatalogItem() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(pizzas);
        SaveFile.saveFile(fileName, strGson);
    }

    @Override
    public void printMenuCatalogItem() {
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.printf("%-3d: %s\n", (i + 1), pizzas.get(i).printFromMenu());
        }
    }

    @Override
    public <ITEM > ITEM cloneItem(ITEM item, int choiceItem){
        System.out.printf("Размер \n1  :L  \n2  :XL\n");
        int size = Input.nextInt();
        if (size == 2) {
            item = (ITEM) pizzas.get(choiceItem - 1).getClonePizzaSizeL();
        } else {
            item = (ITEM) pizzas.get(choiceItem - 1).getClonePizzaSizeXL();
        }
        return item;
    }

    private ArrayList<Pizza> loadCatalogPizza(String fileName) {
        ArrayList<Pizza> ingredientPizzas;
        JsonReader jsonReader;
        Gson gson = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/" + fileName)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));
            ingredientPizzas = gson.fromJson(jsonReader,
                    new TypeToken<ArrayList<Pizza>>() {
                    }.getType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ingredientPizzas;
    }
}
