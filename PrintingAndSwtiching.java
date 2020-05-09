package CrudOperations;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.util.Scanner;

public class PrintingAndSwtiching {

    private Student student = new Student();
    private Scanner sc = new Scanner(System.in);
    private Connector connector = new Connector();

    public void justPrinting() {
        System.out.println("1) ADD STUDENT ");
        System.out.println("2) DELETE STUDENT");
        System.out.println("3) DISPLAY STUDENT");
        System.out.println("4) UPDATE STUDENT");
        System.out.println("5) EXIT");
    }

    public void multipleChoices(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter Your FirstName : ");
                String fname = sc.next();
                System.out.print("Enter Your LastName : ");
                String lname = sc.next();
                System.out.print("Enter Your Age : ");
                int age = sc.nextInt();
                student.settingStudents(fname, lname, age);
                connector.insertData(student);
                break;
            case 2:
                System.out.print("Enter Your Student Id To Delete : ");
                int delete = sc.nextInt();
                connector.deleteStudent(delete);
                break;
            case 3:
                connector.displayData();
                break;
            case 4:
                System.out.println("Enter your Student Id To Updating The Process : ");
                int studentid = sc.nextInt();
                System.out.println("1) update first name");
                System.out.println("2) update last name");
                System.out.println("3) update age");
                System.out.println("4) main menu ");
                System.out.print("Choice : ");
                int choice1 = sc.nextInt();
                connector.updateStudent(studentid, choice1);
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }

}
