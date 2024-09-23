package CentralApp;
import CentralApp.ResourcesOrganization.Company;
import CentralApp.ResourcesOrganization.Department;
import CentralApp.ResourcesOrganization.Employee;
import Data.TimeRecord;

public class MainCentralApp {
    public static void main(String[] args) {

        //Test Structure Ressources
        Company C = new Company(1,"Polytech");
        C.addDepartment("DI");
        C.addDepartment("DMS");
        C.addDepartment("DAE");


        Department D = C.getDepartmentByName("DI");
        Department D2 = C.getDepartmentByName("DMS");
        Department D3 = C.getDepartmentByName("DAE");

        D.addEmployee("Mohamed");
        D.addEmployee("Anas");

        D2.addEmployee("Ecrou");
        D2.addEmployee("3D");

        D3.addEmployee("Arbre");

        Employee E = D.getEmployeeByName("Mohamed");
        Employee E8 = C.getEmployeeById(E.getEmployeeId());
        System.out.println("UUID: "+E.getEmployeeId()+"  /Name: "+E.getEmployeeName());
        System.out.println("UUID2: "+E8.getEmployeeId()+"  /Name2: "+E8.getEmployeeName());

        E.setArrivalDate("8:15:00");
        E.setDepartureDate("18:04:00");
        System.out.println("TotalHoursWorked:  "+E.calculateTotalHours());

        Employee E2 = D.getEmployeeByName("Anas");
        TimeRecord TR = new TimeRecord();
        TR.setIdEmployee("  UUID");
        E2.clockInOut(TR);
        E2.clockInOut(TR);

        Employee E3 = C.getEmployeeByName("Ecrou");
        TimeRecord TR3 = new TimeRecord();
        E3.clockInOut(TR3);
        E3.clockInOut(TR3);


        C.DepartmentListToString();
        System.out.println("TotalHoursWorked:  "+E2.calculateTotalHours());


        //Test Pointage
        TimeRecord TR2 = new TimeRecord();
        TR2.setIdEmployee(" UUID2");
        C.addTimeRecord(TR2);
        C.addTimeRecord(TR);
        CentralAppGui  Gui = new CentralAppGui(C);

        String S = TR.toString();
    }

}
