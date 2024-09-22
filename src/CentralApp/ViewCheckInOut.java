package CentralApp;

import CentralApp.ResourcesOrganization.Company;
import CentralApp.ResourcesOrganization.Department;
import CentralApp.ResourcesOrganization.Employee;
import Data.TimeRecord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ViewCheckInOut {


    private JPanel panel;
    private static JTable tableWithCheckIn_s;
    private JScrollPane jScrollPane;
    private DefaultTableModel table;
    private boolean EmployeeView = false;


    public ViewCheckInOut(boolean bool) {
        EmployeeView = bool;
        //On initialise notre panel principal en lui appliquant le layout (Border)
        panel = new JPanel();
        panel.setLayout(new BorderLayout());


        //Par la suite on cree une Default Table ou on specifie directement nos titre de colognes pour gérer nos donnes dans la jtable
        if(EmployeeView) {
            table = new DefaultTableModel(new Object[]{ "Hour" ,"StockHeure", "Date"}, 0);
        }else{
            table = new DefaultTableModel(new Object[]{"ID", "Nom", "Arrval Hour","Departure Hour","StockHeure", "Date"}, 0);
        }
        //On cree notre jtable
        tableWithCheckIn_s = new JTable(table);

        //On ajoute un scrollpane
        jScrollPane = new JScrollPane(tableWithCheckIn_s);
        panel.add(jScrollPane, BorderLayout.CENTER);

        BlackDesign();
    }

    public void setEmployeeView(boolean employeeView) {
        EmployeeView = employeeView;
    }

    private void BlackDesign() {
        panel.setBackground(Color.BLACK);
        tableWithCheckIn_s.getTableHeader().setBackground(Color.DARK_GRAY);
        tableWithCheckIn_s.getTableHeader().setForeground(Color.WHITE);
        tableWithCheckIn_s.setBackground(Color.BLACK);
        tableWithCheckIn_s.setForeground(Color.WHITE);
        tableWithCheckIn_s.setGridColor(Color.GRAY);
        tableWithCheckIn_s.setSelectionBackground(Color.DARK_GRAY);
        tableWithCheckIn_s.setSelectionForeground(Color.WHITE);
        jScrollPane.getViewport().setBackground(Color.BLACK);
    }


    public void addRows(Company C , String Param){
        if (Objects.equals(Param, "Null")){
            addAllEmployeesData( C, Param);
        }
        else {
            addEmployeeData(C,Param);
        }
    }

    public void addAllEmployeesData(Company C, String Name) {
        for(Department D: C.getDepartments()) {
            for (Employee E: D.getEmployeeList()) {
                table.addRow(new Object[]{E.getEmployeeId(), E.getEmployeeName(), E.getArrivalDate(), E.getDepartureDate(), E.calculateTotalHours(), E.getDate()});
            }
        }
    }

    public void addEmployeeData(Company C, String Name) {
        Employee E = C.getEmployeeByName(Name);
        for(TimeRecord T: E.getTimeRecordsList()) {
            table.addRow(new Object[]{T.getHeureDePointage() , E.calculateTotalHours(), E.getDate()});
        }
    }

    public void startViewMonitoring() {
        JFrame frame = new JFrame("Monitoring View");

        frame.setContentPane(this.panel);
        frame.pack();
        frame.setSize(600, 400);
        frame.setLocation(800,200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ViewCheckInOut v = new ViewCheckInOut(false);
        v.startViewMonitoring();
    }
}

