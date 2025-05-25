import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        // Заполняем штат сотрудников
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee( new Employee("Баранов Виталий Викторович", 1, 92000));
        employeeBook.addEmployee( new Employee("Каштанов Николай Кириллович", 4, 65000));
        employeeBook.addEmployee( new Employee("Ландышев Кирилл Михайлович", 5, 57000));
        employeeBook.addEmployee( new Employee("Ландышев Сергей Михайлович", 5, 85000));
        employeeBook.addEmployee( new Employee("Самсонов Дмитрий Сергеевич", 2, 87000));
        employeeBook.addEmployee( new Employee("Свиридов Виктор Витальевич", 5, 88000));
        employeeBook.addEmployee( new Employee("Яковчик Валерий Фёдорович", 5, 64000));
        employeeBook.addEmployee( new Employee("Попов Михаил Кириллович", 3, 78000));
        employeeBook.addEmployee( new Employee("Клёц Фёдор Сергеевич", 1, 53000));
        employeeBook.addEmployee( new Employee("Чучуев Алексей Дмитриевич", 5, 59000));

        // Полный список сотрудников
        System.out.println();
        employeeBook.printEmployees();
        // Индексируем ЗП
        employeeBook.toIndexSalary(10);
        // Полный список сотрудников после индексации
        System.out.println();
        employeeBook.printEmployees();
        // Добавляем лишнего сотрудника
        System.out.println();
        //employeeBook.addEmployee("Конопля Алексей Валерьевич", 5, 75000);
        // Удаляем сотрудника
        employeeBook.removeEmployee(7);
        employeeBook.removeEmployee(14);
        employeeBook.removeEmployee(4);
        // Печатаем сотрудников по именам
        System.out.println();
        employeeBook.printNames();

        // Работаем с ЗП
        System.out.println();
        System.out.println("Общая сумма затрат на ЗП за месяц = "+ employeeBook.countAllSalary() +"р.");
        System.out.println("Сотрудник с min ЗП: "+ employeeBook.findMinSalary());
        System.out.println("Сотрудник с max ЗП: "+ employeeBook.findMaxSalary());
        System.out.println("Средняя ЗП сотрудника = "+ employeeBook.findMiddleSalary() +" р.");

        // Работаем с отделами
        System.out.println();
        System.out.println("Сотрудник с min ЗП по отделу: "+ employeeBook.findMinSalaryDept(5));
        System.out.println("Сотрудник с max ЗП по отделу: "+ employeeBook.findMaxSalaryDept(5));
        System.out.println("Общая сумма затрат на ЗП по отделу составляет "+ employeeBook.countSalaryDept(5) +" р.");
        System.out.println("Средняя ЗП по отделу составляет "+ employeeBook.findMiddleSalaryDept(5) +" р.");
        // Список сотрудников отдела
        employeeBook.printEmployeesDept(1);
        // Индексация ЗП сотрудниуов отдела
        employeeBook.toIndexSalaryDept(1, 10);
        // Список сотрудников отдела после индексации
        employeeBook.printEmployeesDept(1);

        System.out.println();
        employeeBook.findSalaryLess(75000);
        System.out.println();
        employeeBook.findSalaryMore(75000);

        // Поиск сотрудника по id
        System.out.println();
        System.out.println(employeeBook.findEmployeeId(7));
        System.out.println(employeeBook.findEmployeeId(5));
    }
}
