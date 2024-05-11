package Apartment.dailyRegister;


import Apartment.dbConnection.RegisterConnection;
import Apartment.models.Register;
import Apartment.util.Utility;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegisterModel {
    private static RegisterView registerView;
    private static RegisterConnection registerconnect=new RegisterConnection();
    public RegisterModel(RegisterView registerView){
        this.registerView=registerView;
    }

    public void addDetails(String vehicle) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        if(registerconnect.addDetails(vehicle, date, formatTime)){
            Utility.showAlert("Added sucessfully");
        }else{
            Utility.showAlert("Try Again");
        }
    }

    public List<Register> viewRegistry() {
        return registerconnect.viewRegistry();
    }

    public Register searchRegister(String vehicle) {
        return registerconnect.searchRegister(vehicle);
    }

    public void updateIntime(String vehicle) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        int res=registerconnect.updateIntime(vehicle, Date.valueOf(date), formatTime);
        if(res>=1){
            Utility.showAlert("Intime updateded sucessfully");
        }else
            Utility.showAlert("Try Again");
    }
}
