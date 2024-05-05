package Apartment.tenant;

import Apartment.database.TenantConnection;
import Apartment.login.LoginView;
import Apartment.models.Tenant;
import Apartment.util.Utility;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TenantModel {
    private TenantView tenantView;
    public TenantModel(TenantView tenantView){
        this.tenantView=tenantView;
    }

    public void addTenant(int regno, String name, String block, String house, String address, String vehicle, String parkingSlot) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        if(TenantConnection.addTenant(regno, name, block, house, address, vehicle, Date.valueOf(date), formatTime, parkingSlot)){
            Utility.showAlert("Tenant Added sucessfully");
        }else{
            Utility.showAlert("Try Again");
        }

    }

    public List<Tenant> viewAllTenant() {
        return TenantConnection.viewAllTenant();
    }

    public Tenant searchTenant(int regno) {
        return TenantConnection.searchTenant(regno);
    }

    public int deleteTenant(int regno, String reason) {
        return TenantConnection.deleteTenant(regno, reason);
    }

    public void update(int regno, String column, String data) {
        TenantConnection.updateTenant(regno, column, data);
    }
}
