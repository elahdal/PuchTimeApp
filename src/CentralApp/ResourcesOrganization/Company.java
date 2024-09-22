package CentralApp.ResourcesOrganization;

import Data.TimeRecord;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int companyId;
    private String companyName;
    private List<TimeRecord> AllTimeRecordsHistory;
    private List<Department> departments;
    private ArrayList<Employee> AllEmployee;

    // Constructor
    public Company(int companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.AllTimeRecordsHistory = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    // Getters and Setters

    public int Size(){
        return AllTimeRecordsHistory.size();
    }
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<TimeRecord> getAllTimeRecordsHistory() {
        return AllTimeRecordsHistory;
    }

    public void addTimeRecord(TimeRecord timeRecord) {
        this.AllTimeRecordsHistory.add(timeRecord);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Department getDepartmentById(int Id){
        return departments.get(Id);
    }

    public Department getDepartmentByName(String name) {
        for (Department department : departments) {
            if (department.getDepartmentName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        return null; // Return null if no department matches the name
    }

    public void DepartmentListToString(){
        System.out.println( "+++++++++++++++++++++++++Department In :" +companyName+"+++++++++++++++++++++++++");
        for(Department e : departments){
            e.EmployeeListToString();
        }
        System.out.println( "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public Employee getEmployeeById(String Id) {
        for (Department D : departments){
            return D.getEmployeeById(Id);
        }
        return null;
    }

    public Employee getEmployeeByName(String Name) {
        for (Department D : departments) {
            Employee employee = D.getEmployeeByName(Name);
            if (employee != null) {
                return employee;
            }
        }
        return null; // Return null only if no employee is found in any department
    }

        public void addDepartment(String departmentName) {
        this.departments.add(new Department(departments.size() + 1, departmentName));
    }

    public void deleteDepartment(String departmentName) {
        // Logic to delete department by name
    }

    // Methods for managing employees
    public void addEmployee(String Name, Department department) {
        department.addEmployee(Name);
    }

    public void deleteEmployee(Employee employee) {
        // Logic to delete employee
    }

    public void modifyEmployee(Employee employee) {
        // Logic to modify employee details
    }

    // Methods for checking time records
    public void checkTimeRecords(List<TimeRecord> timeRecordsHistory) {
        // Logic for checking time records
    }

    public void checkTimeRecordsByDay(List<TimeRecord> timeRecordsHistory, String date) {
        // Logic for checking time records for a specific day
    }

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> allEmployees = new ArrayList<>(); // Initialiser une nouvelle liste à chaque appel
        for (Department D : departments) {
            allEmployees.addAll(D.getEmployeeList()); // Ajouter tous les employés d'un département directement
        }
        return allEmployees;
    }


    public void setAllEmployee(ArrayList<Employee> allEmployee) {
        AllEmployee = allEmployee;
    }
}