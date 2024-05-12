package Apartment.guest;


import Apartment.datas.GuestConnection;
import Apartment.models.Guest;
import Apartment.util.Utility;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GuestModel {
    private GuestView guestView;
    private GuestConnection guestConnect=new GuestConnection();
    public GuestModel (GuestView guestView){
        this.guestView=guestView;
    }

    public void addGuest(String vehicle, String block, String house, String parking_slot, String reason) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        if(guestConnect.addGuest(vehicle, block,house, Date.valueOf(date), formatTime, parking_slot, reason)){
            Utility.showAlert("Guest Added sucessfully");
        }else{
            Utility.showAlert("Try Again");
        }

    }

    public Guest searchGuest(String vehicle) {
        return guestConnect.searchGuest(vehicle);
    }
    public List<Guest> viewAllGuest() {
        return guestConnect.viewAllGuest();
    }

    public void updateOut(String vehicle) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        int res=guestConnect.updateGuestOut(vehicle, Date.valueOf(date), formatTime);
        if(res>=1){
            Utility.showAlert("Guest Outtime updateded sucessfully");
        }else
            Utility.showAlert("Try Again");
    }
}
