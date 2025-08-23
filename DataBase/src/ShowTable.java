import java.sql.*;

public class ShowTable {
    public static final String url = "jdbc:mysql://localhost:3306/java";
    public static final String user = "root";
    public static final String pass = "@Devi123";

    public static void main(String []args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded Successfully ..");
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Connection Successful ...");
                String query="SELECT * FROM STUDENTS;";
                Statement stmt= con.createStatement();
                ResultSet rs= stmt.executeQuery(query);
                System.out.println("\n------Student Record------");
                while (rs.next()){
                    int id=rs.getInt("id");
                    String name=rs.getString("name");
                    String course=rs.getString("course");
                    float mark=rs.getFloat("mark");
                    System.out.println("ID: "+id+"| Name:"+name+"| Course "+course+"| mark:"+mark);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
