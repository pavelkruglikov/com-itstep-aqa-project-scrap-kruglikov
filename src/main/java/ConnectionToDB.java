import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToDB {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD =  "FORM-gifted-bile";
    private static final String DB_URL ="jdbc:postgresql://localhost:5432/scrapDB";
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
