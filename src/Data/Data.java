package Data;

import CentralApp.ResourcesOrganization.Employee;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
    private final ArrayList<Employee> EmployeeList;

    public Data(ArrayList<Employee> EmployeeList){
        this.EmployeeList = EmployeeList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return EmployeeList;
    }
}
