package Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeRecord implements Serializable {
    private String IdEmployee;
    private String HeureDePointage;
    private String date;
    private String Name;

    public String getDate() {
        return date;
    }

    public String getHeureDePointage() {
        return HeureDePointage;
    }

    public String getIdEmployee() {
        return IdEmployee;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeureDePointage(String heureDePointage) {
        HeureDePointage = heureDePointage;
    }

    public void setIdEmployee(String idEmployee) {
        IdEmployee = idEmployee;
    }

    public TimeRecord(){
        //IdEmpolyee= input.Idimpoyee

        LocalDateTime now = LocalDateTime.now();

        // Format date as "yyyy-MM-dd"
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = now.format(dateFormatter);

        // Format time as "HH:mm:ss"
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        HeureDePointage = now.format(timeFormatter);

    }


    @Override
    public String toString(){
        System.out.println("Id" +IdEmployee+ "Date" +date+ "Heure"+HeureDePointage);
        return "Id" +IdEmployee+ "Date" +date+ "Heure"+HeureDePointage;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

