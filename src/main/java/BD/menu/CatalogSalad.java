package BD.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import helper.Input;
import helper.SaveFile;
import product.pizza.Pizza;
import product.salad.Salad;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CatalogSalad implements CatalogItem {
    private ArrayList<Salad> salads = new ArrayList<>();
    private final String fileName = "salad.json";

    public CatalogSalad() {
        salads = loadCatalogItem(fileName );
    }

    private ArrayList<Salad> loadCatalogItem(String fileName) {
        ArrayList<Salad> salads;
        JsonReader jsonReader;
        Gson gson = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/" + fileName)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));
            salads = gson.fromJson(jsonReader,
                    new TypeToken<ArrayList<Salad>>() {
                    }.getType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return salads;
    }

    @Override
    public void addNewCatalogItem() {
        System.out.print("Ведите название салата: ");
        String name = Input.nextSting();
        System.out.print("Ведите состав салата: ");
        String description = Input.nextSting();
        System.out.print("Ведите цену салата: ");
        double cost = Input.nextDouble();
        salads.add(new Salad(name, description, cost));
        saveCatalogItem();
    }

    @Override
    public void printMenuCatalogItem() {
        for (int i = 0; i < salads.size(); i++) {
            System.out.printf("%-3d: %s\n", (i + 1), salads.get(i).printFromMenu());
        }
    }

    @Override
    public <ITEM> ITEM cloneItem(ITEM item, int choiceItem) {
        item = (ITEM) salads.get(choiceItem - 1).getClone();
        return item;
    }

    @Override
    public void saveCatalogItem() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(salads);
        SaveFile.saveFile(fileName, strGson);
    }
}
