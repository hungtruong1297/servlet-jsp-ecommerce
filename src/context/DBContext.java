package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    // Original
    public Connection getConnection() throws Exception{
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databaseName"+dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://"+serverName+":"+portNumber + ";databaseName="+dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url,userID,password);
    }

    // This is for testing Connection
    // If return Connection ID -> Successful
    // If not, try Driver and URL
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
        } catch (Exception e) {

        }
    }

        // Original
//    private final String serverName = "10.211.55.5";
        // Modified
        private final String serverName = "localhost";
        private final String dbName = "ShoppingDB";
        private final String portNumber = "1433";
        private final String instance = "";
        private final String userID = "sa";
        private final String password = "Cuchai123";
    }







