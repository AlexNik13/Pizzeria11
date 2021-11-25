package BD.menu;

import product.salad.Salad;

import java.util.ArrayList;

public class CatalogSalad implements CatalogItem {
    private ArrayList<Salad> salads = new ArrayList<>();
    private final String fileName = "salad.json";

    public CatalogSalad(ArrayList<Salad> salads) {
        this.salads = salads;
    }


    @Override
    public void addNewCatalogItem() {

    }

    @Override
    public void printMenuCatalogItem() {

    }

    @Override
    public <ITEM> ITEM cloneItem(ITEM item, int choiceItem) {
        return null;
    }

    @Override
    public void saveCatalogItem() {

    }
}
