package orders;

import java.io.*;
import java.util.ArrayList;

public class Orders  {
    private ArrayList<Check> checks = new ArrayList<>();
    private final String fileName = "orders.json";

    public Orders() {
         //TODO Do not work
           this.checks = loadCheckList(fileName);
    }

    public void addNewCheckFromClient() {
        checks.add(new Check().start());
    }

    public void saveCatalogPizza() {
       /* Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strGson = gson.toJson(checks);
        SaveFile.saveFile(fileName, strGson);*/

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/BD/file/orders.dat")))
        {
            oos.writeObject(checks);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }



    public void printHistoryCheck() {
        for (Check check : checks) {
            System.out.printf("№: %25s - сумма: %.2f\n", check.getNumberCheck(), check.getTotalCost());
        }
    }

    //TODO not work
    private ArrayList<Check> loadCheckList(String fileName) {
        ArrayList<Check> ingredientPizzas = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/BD/file/orders.dat")))
        {
            ingredientPizzas =(ArrayList<Check>)ois.readObject();

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        return ingredientPizzas;
    }
}
