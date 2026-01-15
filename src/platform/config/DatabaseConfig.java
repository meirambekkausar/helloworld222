package platform.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConfig {
    private static final String URL =
            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USER = "postgres.sgmnmqeyaptivfqsatrm";
    private static final String PASSWORD = "Eileenbelserion1234567890_";  // ← DATABASE PASSWORD
    private DatabaseConfig() {
// no instances
    }

    public static Connection getConnection() throws SQLException {
        try {
            // Загружаем драйвер (иногда помогает)
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}