package CrudOperations;
import java.util.Scanner;
public class PrintingAndSwtiching {
    private Student student = new Student();
    private Scanner sc = new Scanner(System.in);
    private Connector connector = new Connector();
    public void justPrinting() {
        System.out.println("1) ADD STUDENT ");
        System.out.println("2) DELETE STUDENT");
        System.out.println("3) DISPLAY STUDENT");
        System.out.println("4) EXIT");
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
                //System.out.println(student.toString());
                break;
            case 2:
                
                break;
            case 3:
                connector.displayData();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }

}
