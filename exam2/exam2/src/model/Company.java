package model;

import java.util.List;
import java.util.UUID;

public class Company {
    public UUID id;
    public String name;
    public List<Employee> employees;

    public Company() {
        this.id = UUID.randomUUID();
    }

    public Company(String name,  List<Employee> employees) {
        this();
        this.employees=employees;
        this.name = name;

    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
