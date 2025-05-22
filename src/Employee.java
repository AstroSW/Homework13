import java.util.Objects;

public class Employee {
    private final String fullName;
    private int dept;
    private double salary;
    private int id;
    private static int counter;

    public Employee (String fullName, int dept, double salary) {
        this.fullName = fullName;
        this.dept = dept;
        this.salary = salary;
        this.id = ++counter;
    }
    
    public String getFullName() {
        return fullName;
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
        return "id "+ id +", "+ fullName +", "+ "отдел № "+ dept +", "+ salary +" р.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fullName);
    }
}
