import java.sql.*;
public class Pratice2 {
    public static final String url="jdbc:mysql://localhost:3306/java";
    public static final String user="root";
    public static final String pass="@Devi123";

    public static void main(String[] args) {
        try{
            int id=310;
            String name="Akasha",course="B.tech";
            double mark=90;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);
            if (con != null){
                System.out.println("Connected Successfully....");
                String q="INSERT INTO STUDENTS (ID,NAME,COURSE,MARK) VALUES( ?,?,?,?);";
                PreparedStatement pstm= con.prepareStatement(q);
                pstm.setInt(1,id);
                pstm.setString(2,name);
                pstm.setString(3,course);
                pstm.setDouble(4,mark);
                int x=pstm.executeUpdate();
                if(x>0){
                    System.out.println("Data Entered Successfully...");
                }
                // Without ID AND USING STATEMENTS INSIDE OF PREPARESTATEMENT
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
