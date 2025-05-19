import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private int dept;
    private double salary;
    private int id;
    private static int counter;

    public Employee (String lastName, String firstName, String middleName, int dept, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dept = dept;
        this.salary = salary;
        this.id = ++counter;
    }
    
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public int getDept() {
        return dept;
    }
    public double getSalary() {
        return salary;
    }
    public int getId() { return id;}

    public void setDept(int dept) { this.dept = dept; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "id "+ id +", "+ lastName +" "+ firstName +" "+ middleName +", "+ "отдел № "+ dept +", "+ salary +" р.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName);
    }
}
