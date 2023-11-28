import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class GenerateClassFile {

    public static void generateClassFiles(String directory,String extension,HashMap<String,String> aboutFiles){
         for (Map.Entry<String, String> entry : aboutFiles.entrySet()) {
            String originalKey = entry.getKey();
            String correctedKey = originalKey.substring(0, 1).toUpperCase() + originalKey.substring(1);
            String fileName = correctedKey + extension;
            String fileContent = entry.getValue();

            // Create directory if it doesn't exist
            try {
                Files.createDirectories(Paths.get(directory));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            // Create and write to the file
            Path filePath = Paths.get(directory, fileName);
            try {
                Files.write(filePath, fileContent.getBytes());
                System.out.println("File generated: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
}
