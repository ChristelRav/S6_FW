import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Type {
    private Map<String, String> typeMap;

    public Type(String filePath) {
        this.typeMap = loadTypeMapping(filePath);
    }

    private Map<String, String> loadTypeMapping(String filePath) {
        Map<String, String> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().startsWith("#")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        String typeBdd = parts[0].trim();
                        String typeJava = parts[1].trim();
                        map.put(typeBdd, typeJava);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public String getJavaType(String typeBdd) {
        return typeMap.get(typeBdd);
    }

    public static void main(String[] args) {
        Boolean b = true;
        Type typeMapping = new Type("Type_java_mysql.props");
        String typeJavaChar = typeMapping.getJavaType("integer");
        System.out.println("Type Java : " + typeJavaChar);

        String typeJavaVarchar = typeMapping.getJavaType("boolean");
        System.out.println("Type Java : " + typeJavaVarchar);
    }
}
