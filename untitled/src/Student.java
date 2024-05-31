// 1. `extends` pulls all non-private members from Person
// into Student.
public class Student extends Person {

    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Student(String firstName, String lastName, String studentId) {
        // 2. call the constructor on the "super" (or parent) class
        super(firstName, lastName);
        this.studentId = studentId;
    }

}