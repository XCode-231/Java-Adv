import java.sql.*;
import java.util.Scanner;

public class Auth {
    public static final String url = "jdbc:mysql://localhost:3306/java";
    public static final String user="root";
    public static final String pass="@Devi123";

    public static void main(String[] args) {
        Connection con=null;
        ResultSet rs=null;
        Statement stmt=null;
        Scanner sc= new Scanner(System.in);
        String name,username,password;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            String q="SELECT username , password FROM LOGIN ";
            if(con != null){
                System.out.println("Connected Successfully ....");
                System.out.print("Enter Use Name :");
                name=sc.next();
                System.out.print("Enter Username :");
                username=sc.next();
                System.out.print("Enter Password :");
                password=sc.next();
                stmt= con.createStatement();
                rs=stmt.executeQuery(q);
                boolean found=false;
                String ur,pass;
                while(rs.next()){
                    ur=rs.getString("username");
                    pass= rs.getString("password");
                    if(username.equals(ur)&& password.equals(pass)){
                        found=true;
                        break;
                    }
                }
                if(found){
                    System.out.println("Login Successful");
                }else{
                    System.out.println("Please ! Verify Credentials ...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
