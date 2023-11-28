import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class GenerateMetadata{

    public static ResultSetMetaData getDatabaseMetadata(Connection connection,String tableName, String database) throws SQLException {

        String query = "SELECT * FROM " + tableName + " WHERE 1=0";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                
                ResultSetMetaData metaData = resultSet.getMetaData();
                
                return metaData;
            }
    }
}