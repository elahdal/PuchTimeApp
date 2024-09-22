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

    public Employee getEmployeeByName(String name) {
        for (Employee e : employeeList) {
            if (e.getEmployeeName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    public Employee getEmployeeById(String Id) {
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equalsIgnoreCase(Id)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void EmployeeListToString(){
        System.out.println( "=======================Employee In :" +departmentName+" =======================");
        for(Employee e : employeeList){
            System.out.println( e.getEmployeeName());
        }
    }

    public void addEmployee(String Name) {
        Employee E = new Employee(Name);
        this.employeeList.add(E);
    }

    public void removeEmployee(String employeeId) {
        // Logic to remove employee by ID
    }

    public Employee getEmployee(String employeeId) {
        // Logic to get employee by ID
        return null; // Placeholder
    }
}
