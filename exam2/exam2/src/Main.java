import model.Employee;
import service.CompanyService;
import service.EmployeeService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    static EmployeeService employeeService = new EmployeeService();
    static CompanyService companyService = new CompanyService();
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);

    public static void main(String[] args) {

        int choose = 244;

        while (true) {
            mainMenu();
            System.out.println("Choose manu:");
            choose=scannerInt.nextInt();
            switch (choose) {
                case 1 -> creatManager();
                case 2 -> creatEmployee();
                case 3 -> getEmployeeByManagerId();
                case 4 -> removeManager();
                case 5 -> creatCompany();
                case 6 -> getEmployeeByCompanyId();
                case 7 -> removeCompany();
                case 8 -> getCompany();
            }

        }

    }

    private static void getCompany() {
        companyService.getCompanies().forEach(System.out::println);
    }

    private static void removeCompany() {
        companyService.getCompanies().forEach(System.out::println);
        System.out.println("Enter company id");
        String id = scannerStr.nextLine();
        String result = companyService.removeCompany(UUID.fromString(id));
        System.out.println(result);
    }

    private static void getEmployeeByCompanyId() {
        companyService.getCompanies().forEach(System.out::println);
        System.out.println("Enter company id");
        String id = scannerStr.nextLine();
        List<Employee> employeeByCompanyId = companyService.getEmployeeByCompanyId(UUID.fromString(id));
        employeeByCompanyId.forEach(System.out::println);
    }

    private static void creatCompany() {
        System.out.println("Enter name:");
        String name = scannerStr.nextLine();
        companyService.createCompany(name, employeeService.employeesList);

    }

    private static void removeManager() {
        employeeService.getManager().forEach(System.out::println);
        System.out.println("Enter manager id");
        String id = scannerStr.nextLine();

        String result = employeeService.removeManager(UUID.fromString(id));
        System.out.println(result);
    }

    private static void getEmployeeByManagerId() {

        employeeService.getManager().forEach(System.out::println);
        System.out.println("Enter manager id");
        String id = scannerStr.nextLine();

        List<Employee> employeesListByManagerId = employeeService.getEmployeesListByManagerId(UUID.fromString(id));
        if (employeesListByManagerId==null) {
            System.out.println("Not found");
            return;
        }

        employeesListByManagerId.forEach(System.out::println);
    }

    private static void creatEmployee() {
        System.out.println("Enter name:");
        String name = scannerStr.nextLine();
        employeeService.getManager().forEach(System.out::println);
        System.out.println("Enter manager id");
        String id = scannerStr.nextLine();
        String result = employeeService.creatEmployee(name, UUID.fromString(id));
        System.out.println(result);
    }

    private static void creatManager() {
        System.out.println("Enter name:");
        String name = scannerStr.nextLine();
        String result = employeeService.creatManager(name);
        System.out.println(result);

    }

    private static void mainMenu() {
        System.out.println("1. Creat manager");
        System.out.println("2. Creat employee");
        System.out.println("3. get employee by manager id ");
        System.out.println("4. remove manager");
        System.out.println("5. create company");
        System.out.println("6. get employee by company id");
        System.out.println("7. remove company");
        System.out.println("8. get company");
    }
}