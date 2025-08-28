import java.sql.*;
public class Pratice1 {
    public static final String url="jdbc:mysql://localhost:3306/java";
    public static final String user="root";
    public static final String  pass="@Devi123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);
            if (con != null){
                System.out.println("Connected Successfully ...");
                String q="SELECT * FROM STUDENTS ;";
                Statement stmt= con.createStatement();
                ResultSet rs= stmt.executeQuery(q);
                System.out.println(rs);
                while(rs.next()){
                    int id=rs.getInt("id");
                    String name=rs.getString("name");
                    String course=rs.getString("course");
                    float mark=rs.getFloat("mark");
                    System.out.println("Student Id: "+id+"| Name: "+name+"| Course: "+course+"| Marks: "+mark);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
