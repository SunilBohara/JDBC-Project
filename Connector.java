package CrudOperations;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.System.out;

public class Connector {

    //private PrintingAndSwtiching pas = new PrintingAndSwtiching();
    private Scanner sc = new Scanner(System.in);
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
                System.out.println("Id : " + resultset.getInt("id"));
                System.out.println("First Name : " + resultset.getString("fname"));
                System.out.println("Last Name : " + resultset.getString("lname"));
                System.out.println("Age : " + resultset.getInt("age"));
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

    public void deleteStudent(int i) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String q = "delete from students where id = ?";
            PreparedStatement preparedstatement = con.prepareStatement(q);
            preparedstatement.setInt(1, i);
            preparedstatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
    @param id student id
    @param field the field to update
    */
    /*field : eg -> lname, fname, age etc*/
    public void updateStudent(int id, String field){
        
        Scanner scan = new Scanner(System.in);
        String newInfo = null;
            
        switch(field){
            
            case "lname": {
                out.println("Enter new first name: ");
            break;
            }

            case "fname":{
                out.println("Enter new last name: ");
            break;
            }

            case "age":{
                out.println("Enter new age: ");
            break;
            }

            default: {
                out.println("Filed does not exist! Try fname, lname or age");
                //try avoiding exit
                System.exit(0);
            break;
            }
        }
            
        newInfo = scan.nextLine();
        updateDB(id, field, newInfo);
        
        scan.close();
    }
    
    
    private void updateDB(int id, String field, String updated){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String query = "update students set " + field + " = ? where id = ?";
            
            PreparedStatement preparedstatement = con.prepareStatement(query);
            preparedstatement.setString(1, updated);
            preparedstatement.setString(2, String.valueOf(id));
            preparedstatement.executeUpdate();
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
