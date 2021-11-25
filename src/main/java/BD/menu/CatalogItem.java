package BD.menu;

public interface CatalogItem {
    public void addNewCatalogItem();
    public void printMenuCatalogItem();
    public <ITEM > ITEM cloneItem(ITEM item, int choiceItem);
    public void saveCatalogItem();
}
