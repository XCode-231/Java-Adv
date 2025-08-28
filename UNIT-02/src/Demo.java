import java.sql.*;
import java.util.Scanner;

public class Demo {
    public static final String url = "jdbc:mysql://localhost:3306/java";
    public static final String user="root";
    public static final String pass="@Devi123";

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int id;
        String name,username,password;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            String q="SELECT username , password FROM LOGIN where username= ?";
            PreparedStatement pstm = con.prepareStatement(q);
            if(con != null){
                System.out.println("Connected Successfully ....");
                System.out.print("Enter Use Name :");
                name=sc.next();
                System.out.print("Enter Username :");
                username=sc.next();
                System.out.print("Enter Password :");
                password=sc.next();
//                Statement stmt= con.createStatement();
                pstm.setString(1,username);
                ResultSet rs = pstm.executeQuery();
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
        }
    }
}
