public class Instructor extends Person {

    private String employeeId;
    private String title;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Instructor(String firstName, String lastName, String employeeId, String title) {
        super(firstName, lastName); // satisfy the parent constructor requirements
        this.employeeId = employeeId;
        this.title = title;
    }

}
