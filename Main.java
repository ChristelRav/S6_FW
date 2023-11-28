import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;

public class Main {
    public static void main(String[] args) {
        try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/foncier","root","root")) {
            ResultSetMetaData metadata=GenerateMetadata.getDatabaseMetadata(connection,"foncier", "foncier");
            int columnCount = metadata.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + metadata.getColumnName(i));
                System.out.println("Column Type: " + metadata.getColumnTypeName(i));
                System.out.println("-------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}