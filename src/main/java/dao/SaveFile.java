package dao;

import java.io.*;

public class SaveFile {
    private static final String wayFile = "src/main/java/BD/file/";

    public static void saveFile(String nameFile, String save) {

        nameFile =wayFile +  nameFile;

        try (FileOutputStream fileOutputStream = new FileOutputStream(nameFile)) {
            fileOutputStream.write(save.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



   /* public static JsonReader loadBD_ProductFood(String nameFile) {
        nameFile =wayFile +  nameFile;
        JsonReader jsonReader;
        Gson gson  = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream(nameFile)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));


            ArrayList<ProductFood> productFoods = gson.fromJson(jsonReader,
                    new TypeToken<ArrayList<ProductFood>>(){}.getType());



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonReader);
        System.out.println(jsonReader.toString());

        return jsonReader;
    }*/



}
