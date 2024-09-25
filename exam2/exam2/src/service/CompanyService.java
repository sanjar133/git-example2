package service;

import model.Company;
import model.Employee;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompanyService {

    private List<Company> companies = new ArrayList<>();

    public String createCompany(String name, List<Employee> employees){
        Company company = new Company(name, employees);

        companies.add(company);

        return "Company created";
    }

    public List<Company> getCompanies(){
        if (isEmpty()) {
            return null;
        }
        return companies;
    }

    public List<Employee> getEmployeeByCompanyId(UUID companyId){
        if (isEmpty()) {
            return null;
        }

//         getCompanies().forEach(company -> System.out.println(company.getId()+"   "+company.getName()));

        Company companyByID = getCompanyByID(companyId);
        if (companyByID==null) {
            return null;
        }

        return companyByID.getEmployees();


    }

    public String removeCompany(UUID uuid){
        Company companyByID = getCompanyByID(uuid);
        if (companyByID==null) {
            return "not founded at this id";
        }

//         companies.forEach(company -> System.out.println(company.getId()+"   "+company.getName()));

        boolean remove = companies.remove(companyByID);
        if (remove) {
            return "Company removed";
        }
        return "Failed";
    }

    private Company getCompanyByID(UUID id){
        if (isEmpty()) {
            return null;
        }

        for (Company company : companies) {
            if (company.getId().equals(id)) {
                return company;
            }
        }

        return null;

    }

    private boolean isEmpty(){
        return companies.isEmpty();
    }

}
