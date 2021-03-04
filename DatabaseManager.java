import javax.annotation.processing.Processor;
import javax.xml.crypto.Data;
import java.sql.*;
public class DatabaseManager {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:test/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void Test() {
        String sql = "INSERT INTO customer (username, password) Values (testu, testp)";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("customerID") + "\t" +
                        rs.getString("username") + "\t" +
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        DatabaseManager app = new DatabaseManager();
        app.Test();
    }
}

