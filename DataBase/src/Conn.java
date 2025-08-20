import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Conn {
    public static void main(String[] args) {
        // Update these with your actual database information
        String url = "jdbc:mysql://localhost:3306/Java"; // Change your_database_name
        String username = "root"; // Change your_username
        String password = "@Devi123"; // Change your_password

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connected to the database.");

            // Create a statement object
            stmt = conn.createStatement();

            // Query to select all data from the 'Java' table
            String query = "SELECT * FROM Java";

            // Execute the query
            rs = stmt.executeQuery(query);

            // Print result set
            while (rs.next()) {
                // Replace 'id' and 'name' with your actual column names
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ SQL error.");
            e.printStackTrace();
        } finally {
            // Close connections
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("🔒 Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
