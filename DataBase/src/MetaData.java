import java.sql.*;

public class MetaData {
    public static final String url = "jdbc:mysql://localhost:3306/java";
    public static final String user = "root";
    public static final String pass = "@Devi123";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            conn = DriverManager.getConnection(url, user, pass);


            stmt = conn.createStatement();


            rs = stmt.executeQuery("SELECT * FROM students");


            ResultSetMetaData metadata = rs.getMetaData();
            System.out.println("==TABLE METADATA==");
            int columnCount = metadata.getColumnCount();
            System.out.println("Number of columns: " + columnCount);
            System.out.println();

            System.out.println("==Column Details==");
            System.out.printf("%-15s %-15s %-10s %-10s%n", "Column Name", "Type", "Nullable", "Size");

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metadata.getColumnName(i);
                String columnType = metadata.getColumnTypeName(i);
                String nullable = metadata.isNullable(i) == ResultSetMetaData.columnNullable ? "YES" : "NO";
                int columnSize = metadata.getColumnDisplaySize(i);

                System.out.printf("%-15s %-15s %-10s %-10d%n", columnName, columnType, nullable, columnSize);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}