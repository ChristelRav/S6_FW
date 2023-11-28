import java.util.HashMap;

public class GenerateFileMain {
    public static void main(String[] args) {
        String directory = "D:\\project";
        String extension = ".java";

        HashMap<String, String> aboutFiles = new HashMap<>();
        aboutFiles.put("dog", "package animal;\nimport java.sql.Date;\npublic class Dog {\n    String name;\n}");

        GenerateClassFile.generateClassFiles(directory, extension, aboutFiles);
    }
}
