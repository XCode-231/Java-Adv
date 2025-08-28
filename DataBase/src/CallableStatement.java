import java.sql.*;
import java.util.Scanner;

public class CallableStatement {
    public static final String url="jdbc:mysql://localhost:3306/java";
    public static final String user="root";
    public static final String pass="@Devi123";

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int StudentID;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            if (con!=null){
                System.out.println("Connected Successfully ...");
                // Take Input From User
                System.out.print("Enter StudentID to Search :");
                StudentID=sc.nextInt();
                // Calling Stored Procedure
                String sql="CALL getStudentById(?);";
                java.sql.CallableStatement cst= con.prepareCall(sql);
                // Here I Use Fully Qualified name to avoid confusion with the Class Name (CallableStatement)
                cst.setInt(1,StudentID);
                ResultSet rs = cst.executeQuery();
                boolean found=false;
                while(rs.next()){
                    found=true;
                    int id=rs.getInt("id");
                    String name=rs.getString("name");
                    String course=rs.getString("course");
                    float mark=rs.getFloat("mark");
                    System.out.println("StudentID: "+id+" | Name: "+name+" | Course : "+course+" | Mark: "+mark);
                }
                if (!found){
                    System.out.println("No Student Found with ID "+StudentID);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
