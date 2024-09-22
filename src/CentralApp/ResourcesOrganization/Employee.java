package CentralApp.ResourcesOrganization;

import Data.TimeRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Employee {
    private UUID employeeId;
    private String employeeName;
    private String arrivalDate;
    private String departureDate;
    private String date;
    private int hourStock;
    private List<TimeRecord> timeRecordsList;
    private ArrayList<Double> DayTotalHours;

    private boolean CheckIn = true;

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

    public int Size2(){
        return timeRecordsList.size();
    }
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
        if (Objects.isNull(departureDate)) {
            return "Still Working";
        }
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
    public void clockInOut(TimeRecord T) {
        date = T.getDate();
        if(CheckIn){
            CheckIn = false;
            arrivalDate = T.getHeureDePointage();
        }
        else if (Objects.isNull(departureDate)){
            departureDate = T.getHeureDePointage();
        }else {
            //Exception l'utilisateur a pointer plus de deux fois dans la journéé
        }
    }

    public String calculateTotalHours() {

        if (Objects.isNull(arrivalDate)) {
            return "Still Working";
        }else{
            String[] arrivalParts = arrivalDate.split(":");
            String[] departureParts = departureDate.split(":");

            int arrivalHours = Integer.parseInt(arrivalParts[0]);
            int arrivalMinutes = Integer.parseInt(arrivalParts[1]);
            int arrivalSeconds = Integer.parseInt(arrivalParts[2]);

            int departureHours = Integer.parseInt(departureParts[0]);
            int departureMinutes = Integer.parseInt(departureParts[1]);
            int departureSeconds = Integer.parseInt(departureParts[2]);

            // Calculate total seconds
            int totalArrivalSeconds = arrivalHours * 3600 + arrivalMinutes * 60 + arrivalSeconds;
            int totalDepartureSeconds = departureHours * 3600 + departureMinutes * 60 + departureSeconds;

            // Calculate the difference in seconds
            int totalSeconds = totalDepartureSeconds - totalArrivalSeconds;

            // Convert back to hours, minutes, and seconds
            int hours = totalSeconds / 3600;
            int minutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;

            // Format the result as "xx:xx:xx"
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
    }


    public int getTotalOvertime() {
        // Logic to calculate overtime
        return 0; // Placeholder
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}