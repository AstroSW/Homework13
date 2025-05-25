public class EmployeeBook {
    private final Employee [] employees;
    private int size;

    public EmployeeBook () {
        this.employees = new Employee[10];
    }

    // Добавить нового сотрудника
    public void addEmployee (Employee newEmployee) {
        if (size >= employees.length) {
            System.out.println("Увы, набран полный штат сотрудников");
            return;
        }
        employees [size++] = newEmployee;
    }

    // Удалить сотрудника
    public void removeEmployee (int id) {
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            if (e.getId() == id ) {
                System.out.println("Сотрудник id "+ id +" "+ e.getFullName() +" удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees [size -1] = null;
                size --;
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }

    // Поиск сотрудника по id
    public Employee findEmployeeId (int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
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
    public Employee findMinSalary () {
        Employee e = employees[0];
        for (int i = 1; i < size; i++) {
            if (employees[i].getSalary() < e.getSalary()) {
                e = employees[i];
            }
        }
        return e;
    }

    //max ЗП
    public Employee findMaxSalary () {
        Employee e = employees [0];
        for (int i = 1; i < size; i++) {
            if (employees[i].getSalary() > e.getSalary()) {
                e = employees[i];
            }
        }
        return e;
    }

    // Средняя ЗП
    public double findMiddleSalary () {
        if (size != 0) {
            return countAllSalary() / size;
        }
        return size ;
    }

    // Список сотрудников по именам
    public void printNames () {
        System.out.println("Список сотрудников по именам:");
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            System.out.println(e.getFullName());
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
    public Employee findMinSalaryDept (int dept) {
        Employee e = null;
        int i = 0;
        for (; i < size; i++) {
            if (employees[i].getDept() == dept) {
                e = employees[i];
                break;
            }
        }
        for (; i < size; i++) {
            if (employees[i].getDept() == dept && employees[i].getSalary() < e.getSalary())  {
                e = employees[i];
            }
        }
        return e;
    }

    //max ЗП по отделу
    public Employee findMaxSalaryDept (int dept) {
        Employee e = null;
        int i = 0;
        for (; i < size; i++) {
            if (employees[i].getDept() == dept) {
                e = employees[i];
                break;
            }
        }
        for (; i < size; i++) {
            if (employees[i].getDept() == dept && employees[i].getSalary() > e.getSalary()) {
                e = employees[i];
            }
        }
        return e;
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
        if (counter != 0 ) {
            return salary / counter;
        }
        return counter ;
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
        System.out.println();
        System.out.println("Список сотрудников отдела № "+ dept +":");
        for (int i = 0; i < size; i++) {
            Employee e = employees [i];
            if (e.getDept() == dept) {
                System.out.println("id "+ e.getId() +", "+ e.getFullName() +", "+ e.getSalary() +" р.");
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