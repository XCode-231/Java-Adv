import java.sql.*;
import java.util.Scanner;

public class StoreData {
    public static final String url = "jdbc:mysql://localhost:3306/java";
    public static final String user = "root";
    public static final String pass = "@Devi123";

    public static void main(String []args) {
        Scanner sc= new Scanner(System.in);
        int id;
        String name, course;
        double mark;
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded Successfully ..");

            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Connection Successful ...");
//                PreparedStatement pst=con.prepareStatement(query);
//                System.out.print("Enter Student ID :");
//                id=sc.nextInt();
                System.out.print("Enter Student Name :");
                name=sc.next();
                System.out.print("Enter Course :");
                course=sc.next();
                System.out.print("Enter Marks :");
                mark=sc.nextDouble();
                String query = "INSERT INTO STUDENTS (NAME, COURSE, MARK) VALUES ('"
                        + name + "', '" + course + "', '" + mark + "')";
                 Statement stmt =con.createStatement();
                int x=stmt.executeUpdate(query);
//                pst.setInt(1,id);
//                pst.setString(2,name);
//                pst.setString(3,course);
//                pst.setDouble(4,mark);
//                int x=pst.executeUpdate();

                if(x>0){
                    System.out.println("Data Entered Successfully...");
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

