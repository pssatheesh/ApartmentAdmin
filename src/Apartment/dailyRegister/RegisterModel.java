package Apartment.dailyRegister;

import Apartment.database.RegisterConnection;
import Apartment.login.LoginView;
import Apartment.models.Register;
import Apartment.util.Utility;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegisterModel {
    private static RegisterView registerView;
    public RegisterModel(RegisterView registerView){
        this.registerView=registerView;
    }

    public void addDetails(String vehicle) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        if(RegisterConnection.addDetails(vehicle, date, formatTime)){
            Utility.showAlert("Added sucessfully");
        }else{
            Utility.showAlert("Try Again");
        }
    }

    public List<Register> viewRegistry() {
        return RegisterConnection.viewRegistry();
    }

    public Register searchRegister(String vehicle) {
        return RegisterConnection.searchRegister(vehicle);
    }

    public void updateIntime(String vehicle) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        int res=RegisterConnection.updateIntime(vehicle, Date.valueOf(date), formatTime);
        if(res>=1){
            Utility.showAlert("Intime updateded sucessfully");
        }else
            Utility.showAlert("Try Again");
    }
}
