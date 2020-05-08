package CrudOperations;
public class Student {
    
    private String firstname;
    private String lastname;

    @Override
    public String toString() {
        return "Student{" + "firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + '}';
    }
    private int age;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
    
    public void settingStudents(String fn, String ln, int a) {
        this.firstname = fn;
        this.lastname = ln;
        this.age = a;
    }
    
    
}
