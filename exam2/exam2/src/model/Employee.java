package model;

import java.util.UUID;

public class Employee {
    private UUID id;
    private String employeeName;
    public UUID managerId;
    public boolean isManager=false;
    public Employee() {
        this.id = UUID.randomUUID();
    }

    public Employee(String employeeName, UUID managerId) {
        this();
        this.employeeName = employeeName;
        this.managerId = managerId;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public UUID getId() {
        return id;
    }

    public UUID getManagerId() {
        return managerId;
    }

    public void setManagerId(UUID managerId) {
        this.managerId = managerId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", managerId=" + managerId +
                ", isManager=" + isManager +
                '}';
    }
}
