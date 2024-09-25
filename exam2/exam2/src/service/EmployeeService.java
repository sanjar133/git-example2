package service;

import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeService {

    public List<Employee> employeesList = new ArrayList<>();


    public String creatEmployee(String name, UUID managerId){

        Employee employee = new Employee(name,managerId);
        employeesList.add(employee);
        return "Employee added successfully";
    }

    public String creatManager(String name){

        Employee employee = new Employee();
        employee.setEmployeeName(name);
        employee.setManager(true);

        employeesList.add(employee);
        return "Manager added successfully";
    }

    public List<Employee> getEmployeesListByManagerId(UUID managerId){

        if (isEmpty()) {
            return null;
        }

//        List<Employee> manager = getManager();
//        if (manager.isEmpty()) {
//            return null;
//        }
//
//        manager.forEach(employee -> System.out.println(employee.getId()+"  "+employee.getEmployeeName()));

        List<Employee> employees = new ArrayList<>();

        for (Employee employee : employeesList) {
            if (employee.getManagerId()!=null && employee.getManagerId().equals(managerId) ) {
                employees.add(employee);
            }
        }
        if (employees.isEmpty()) return null;

        return employees;
    }

    public List<Employee> getManager(){
        if (isEmpty()) {
            return null;
        }

        ArrayList<Employee> managers = new ArrayList<>();

        for (Employee employee : employeesList) {
            if (employee.isManager) {
                managers.add(employee);
            }
        }

        return managers;
    }

    public String removeManager(UUID managerID){

        Employee employeeById = getEmployeeById(managerID);

        if (employeeById==null) {
            return "not found user at this id";
        }
        employeesList.remove(employeeById);
//        getEmployeesListByManagerId(managerID).forEach(employee -> employee.setManagerId(null));
        List<Employee> employeesListByManagerId = getEmployeesListByManagerId(managerID);
        if (employeesListByManagerId==null) {
            for (Employee employee : employeesListByManagerId) {
                employee.setManagerId(null);
            }
        }

        return "Removed manager";
    }

    private Employee getEmployeeById(UUID id){
        if (isEmpty()) {
            return null;
        }

        for (Employee employee : employeesList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }

        return null;
    }


    private boolean isEmpty(){

        return employeesList.isEmpty();

    }

}
