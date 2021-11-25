package helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class SaveFile {
    private static final String wayFile = "src/main/java/BD/file/";

    public static void saveFile(String nameFile, String save) {
        nameFile = wayFile + nameFile;
        try (FileOutputStream fileOutputStream = new FileOutputStream(nameFile)) {
            fileOutputStream.write(save.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //загружает но потом работать с загруженым списком не хочет.
    //на данный момент лишняя. Позже буду запускать.
    public static <T> T loadList(T list, String fileName) {
        T ingredientPizzas;
        JsonReader jsonReader;
        Gson gson = new GsonBuilder().create();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/" + fileName)) {
            jsonReader = new JsonReader(new InputStreamReader(fileInputStream));
            list = gson.fromJson(jsonReader,
                    new TypeToken<T>() {
                    }.getType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
