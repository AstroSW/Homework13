import java.util.Arrays;

public class EmployeeBook {
    private final Employee [] employees;
    private int size;

    public EmployeeBook () {
        this.employees = new Employee[10];
    }

    // Добавить нового сотрудника
    public void addEmployee (String lastName, String firstName, String middleName, int dept, double salary) {
        if (size >= employees.length) {
            System.out.println("Увы, набран полный штат сотрудников");
            return;
        }
        Employee newEmployee = new Employee(lastName, firstName, middleName, dept, salary);
        employees [size++] = newEmployee;
    }

    // Удалить сотрудника
    public void removeEmployee (int id) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees [i];
            if (e.getId() == id) {
                System.out.println("Сотрудник id "+ id +" "+ e.getLastName() +" "+ e.getFirstName() +" "+ e.getMiddleName() +" удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees [size -1] = null;
                size --;
                return;
            }
        }
    }

    // Поиск сотрудника по id
    public void findEmployeeId (int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }

    // Список всех сотрудников
    public void printEmployees() {
        System.out.println("Полный список сотрудников:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
        System.out.println("Всего сотрудников: "+ size);
    }

    // Сумма затрат на ЗП
    public double countAllSalary() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            sum += e.getSalary();
        }
        return sum;
    }

    // min ЗП
    public void findMinSalary () {
        Employee e = employees[0];
        for (int i = 1; i < size; i++) {
            if (employees[i].getSalary() < e.getSalary()) {
                e = employees[i];
            }
        }
        System.out.println("Сотрудник с min ЗП: "+ e);
    }

    //max ЗП
    public void findMaxSalary () {
        Employee e = employees [0];
        for (int i = 1; i < size; i++) {
            if (employees[i].getSalary() > e.getSalary()) {
                e = employees[i];
            }
        }
        System.out.println("Сотрудник с max ЗП: "+ e);
    }

    // Средняя ЗП
    public double findMiddleSalary () {
        return countAllSalary() / size;
    }

    // Список сотрудников по именам
    public void printNames () {
        System.out.println("Список сотрудников по именам:");
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            System.out.println(e.getLastName() +" "+ e.getFirstName() +" "+ e.getMiddleName());
        }
        System.out.println("Всего сотрудников: "+ size);
    }

    // Индексирование ЗП всех сотрудников
    public void toIndexSalary (int index) {
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            e.setSalary(e.getSalary() + e.getSalary() * index /100);
        }
    }

    // min ЗП по отделу
    public void findMinSalaryDept (int dept) {
        Employee e = employees[0];
        for (Employee i : employees) {
            if (i.getDept() == dept) {
                e = i;
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            if (employees[i].getDept() == dept && employees[i].getSalary() < e.getSalary())  {
                e = employees[i];
            }
        }
        System.out.println("Сотрудник с min ЗП по отделу: "+ e);
    }

    //max ЗП по отделу
    public void findMaxSalaryDept (int dept) {
        Employee e = employees[0];
        for (Employee i : employees) {
            if (i.getDept() == dept) {
                e = i;
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            if (employees[i].getDept() == dept && employees[i].getSalary() > e.getSalary()) {
                e = employees[i];
            }
        }
        System.out.println("Сотрудник с max ЗП по отделу: "+ e);
    }

    // Сумма затрат на ЗП по отделу
    public double countSalaryDept (int dept) {
        double salary = 0;
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            if (e.getDept() == dept) {
                salary += e.getSalary();
            }
        }
        return salary;
    }

    // Средняя ЗП по отделу
    public double findMiddleSalaryDept (int dept) {
        double salary = 0;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            if (e.getDept() == dept) {
                salary += e.getSalary();
                counter ++;
            }
        }
        return salary / counter;
    }

    // Индексация ЗП сотрудников отдела
    public void toIndexSalaryDept (int dept, int index) {
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            if (e.getDept() == dept) {
                e.setSalary(e.getSalary() + e.getSalary() * index /100);
            }
        }
    }

    // Список сотрудников отдела
    public void printEmployeesDept (int dept) {
        System.out.println("Список сотрудников отдела № "+ dept +":");
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            if (e.getDept() == dept) {
                System.out.println("id "+ e.getId() +", "+ e.getLastName() +" "+ e.getFirstName() +" "+ e.getMiddleName() +", "+ e.getSalary() +" р.");
            }
        }
    }

    // ЗП меньше чем...
    public void findSalaryLess (double salary) {
        System.out.println("Список сотрудников с ЗП меньше "+ salary +" р. :");
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            if (e.getSalary() < salary) {
                System.out.println(e);
            }
        }
    }

    // ЗП больше чем...
    public void findSalaryMore (double salary) {
        System.out.println("Список сотрудников с ЗП больше "+ salary +" р. :");
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            if (e.getSalary() >= salary) {
                System.out.println(e);
            }
        }
    }
}
