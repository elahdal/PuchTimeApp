package CentralApp.ResourcesOrganization;

import Data.TimeRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Employee {
    private UUID employeeId;
    private String employeeName;
    private String arrivalDate;
    private String departureDate;
    private int hourStock;
    private List<TimeRecord> timeRecordsList;
    private ArrayList<Double> DayTotalHours;

    private boolean CheckIn = false;

    // Constructor
    public Employee(String employeeName ) {
        this.employeeId = UUID.randomUUID();
        this.employeeName = employeeName;
        this.timeRecordsList = new ArrayList<>();
    }

    // Getters and Setters

    /*public UUID getEmployeeId() {
        return employeeId;
    }*/

    public String getEmployeeId() {
        return employeeId.toString();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getHourStock() {
        return hourStock;
    }

    public void setHourStock(int hourStock) {
        this.hourStock = hourStock;
    }

    public List<TimeRecord> getTimeRecordsList() {
        return timeRecordsList;
    }

    public void addTimeRecord(TimeRecord timeRecord) {
        this.timeRecordsList.add(timeRecord);
    }

    // Other methods
    public void clockInOut() {
        if(CheckIn){
            // pointage.heure = heure d'arrivée
        }
        else{
            // pointage.heure = heure de depart
        }
    }

    public int calculateTotalHours() {
        // Logic to calculate total worked hours
        return 0; // Placeholder
    }

    public int getTotalOvertime() {
        // Logic to calculate overtime
        return 0; // Placeholder
    }
}