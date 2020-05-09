package CrudOperations;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void updateStudent(int studentid, int choice) {
        try {
            
            if (choice == 1) {
                System.out.print("Enter the first new name : ");
                String newname = sc.next();
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
                String q = "update students set fname = ? where id = ?";
                PreparedStatement preparedstatement = con.prepareStatement(q);
                preparedstatement.setString(1, newname);
                preparedstatement.setString(2, String.valueOf(studentid));
                preparedstatement.executeUpdate();
            } else if (choice==2) {
                System.out.print("Enter the last new name : ");
                String lastname = sc.next();
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
                String q = "update students set lname = ? where id = ?";
                PreparedStatement preparedstatement = con.prepareStatement(q);
                preparedstatement.setString(1, lastname);
                preparedstatement.setString(2, String.valueOf(studentid));
                preparedstatement.executeUpdate();
            } else if (choice==3) {
                System.out.println("Enter your new age : ");
                int newage = sc.nextInt();
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
                String q = "update students set fname = ? where id = ?";
                PreparedStatement preparedstatement = con.prepareStatement(q);
                preparedstatement.setInt(1,newage);
                preparedstatement.setInt(2, studentid);
                preparedstatement.executeUpdate();
            } else if (choice==4) {
                
                //pas.multipleChoices(choice);
            } else {
                System.out.println("Invalid Choice");
                System.exit(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent1(String lnn) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudnet2(int age) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void updatingStudents(int choice) {
//
//        switch (choice1) {
//            case 1:
//                
//                break;
//            case 2:
//                
//                break;
//            case 3:
//                
//                break;
//            case 4:
//
//                break;
//            default:
//                System.out.println("Invalid Choice");
//        }
//    }
}
