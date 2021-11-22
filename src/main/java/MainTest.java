import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ingredient.ProductFood;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainTest {



    public static void main(String[] args) {
        ArrayList<ProductFood> integers = new ArrayList<>();

       /* integers.add(new ProductFood("Помидорки", 20));
        integers.add(new ProductFood("Сыр", 250));
        integers.add(new ProductFood("Колбаска", 500));
        integers.add(new ProductFood("wwwwwwwwww", 234));
        integers.add(new ProductFood("eeee", 567));


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String str = gson.toJson(integers);*/



      /*  try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/BD/file/Test.json")) {
            fileOutputStream.write(str.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/


        try(FileInputStream fileInputStream = new FileInputStream("src/main/java/BD/file/Test.json")) {
            JsonReader reader = new JsonReader(new InputStreamReader(fileInputStream));
            Gson gson = new GsonBuilder().create();

            System.out.println(reader);

            integers = gson.fromJson(reader, new  TypeToken<ArrayList<ProductFood>>(){}.getType());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(integers);

    }
}
