import java.sql.*;
import java.util.Scanner;
public class ProductAdd {
    public static final String url = "jdbc:mysql://localhost:3306/java";
    public static final String user = "root";
    public static final String pass = "@Devi123";
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int pid;
        float price;
        String pname,edate;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded Successfully ..");

            Connection con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Connection Successful ...");
                System.out.print("Enter Product ID:");
                pid=sc.nextInt();
                System.out.print("Enter Product Name :");
                pname=sc.next();
                System.out.print("Enter Price:");
                price=sc.nextFloat();
                System.out.print("Enter Expected Date to be Delevered :");
                edate=sc.next();
                String sql = "INSERT INTO PRODUCTS (PID, PNAME, PRICE, EXPECTED_DATE) " +
                        "VALUES (" + pid + ", '" + pname + "', " + price + ", '" + edate + "')";
                Statement stmt =con.createStatement();
                int x=stmt.executeUpdate(sql);
                if (x>0){
                    System.out.println("Added Successfully ....");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
