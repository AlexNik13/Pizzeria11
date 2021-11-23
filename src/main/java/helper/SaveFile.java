package helper;

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
}
