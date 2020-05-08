package CrudOperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Connector {
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/javaproject";
    private String user = "root";
    private String password = "root";
    
    public void displayData() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedstatement = con.prepareStatement("select * from students");
            ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {                
                System.out.println("Id : "+resultset.getInt("id"));
                System.out.println("First Name : "+resultset.getString("fname"));
                System.out.println("Last Name : "+resultset.getString("lname"));
                System.out.println("Age : "+resultset.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertData(Student student) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String q = "insert into students (fname,lname,age) values (?,?,?)";
            PreparedStatement preparedstatement = con.prepareStatement(q);
            preparedstatement.setString(1, student.getFirstname());
            preparedstatement.setString(2, student.getLastname());
            preparedstatement.setInt(3, student.getAge());
            preparedstatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
