import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        // Заполняем штат сотрудников
        employeeBook.addEmployee("Баранов Виталий Викторович", 1, 92000);
        employeeBook.addEmployee("Каштанов Николай Кириллович", 4, 65000);
        employeeBook.addEmployee("Ландышев Кирилл Михайлович", 5, 57000);
        employeeBook.addEmployee("Ландышев Сергей Михайлович", 5, 85000);
        employeeBook.addEmployee("Самсонов Дмитрий Сергеевич", 2, 87000);
        employeeBook.addEmployee("Свиридов Виктор Витальевич", 5, 88000);
        employeeBook.addEmployee("Яковчик Валерий Фёдорович", 5, 64000);
        employeeBook.addEmployee("Попов Михаил Кириллович", 3, 78000);
        employeeBook.addEmployee("Клёц Фёдор Сергеевич", 1, 53000);
        employeeBook.addEmployee("Чучуев Алексей Дмитриевич", 5, 59000);
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
        employeeBook.addEmployee("Конопля Алексей Валерьевич", 5, 75000);
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
        //employeeBook.findEmployeeId(5);
    }

}
