package CentralApp.ResourcesOrganization;

import java.util.ArrayList;

public class Department {
    private int departmentId;
    private String departmentName;
    private ArrayList<Employee> employeeList;

    // Constructor
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employeeList = new ArrayList<>();
    }

    // Getters and Setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public void removeEmployee(String employeeId) {
        // Logic to remove employee by ID
    }

    public Employee getEmployee(String employeeId) {
        // Logic to get employee by ID
        return null; // Placeholder
    }
}
