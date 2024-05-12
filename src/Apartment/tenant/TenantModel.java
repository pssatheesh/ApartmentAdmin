package Apartment.tenant;

import Apartment.datas.TenantConnection;
import Apartment.models.Tenant;
import Apartment.util.Utility;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TenantModel {
    private TenantView tenantView;
    private TenantConnection tenantConnect=new TenantConnection();
    public TenantModel(TenantView tenantView){
        this.tenantView=tenantView;
    }

    public void addTenant(int regno, String name, String block, String house, String address, String vehicle, String parkingSlot) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        if(tenantConnect.addTenant(regno, name, block, house, address, vehicle, Date.valueOf(date), formatTime, parkingSlot)){
            Utility.showAlert("Tenant Added sucessfully");
        }else{
            Utility.showAlert("Try Again");
        }

    }

    public List<Tenant> viewAllTenant() {
        return tenantConnect.viewAllTenant();
    }

    public Tenant searchTenant(int regno) {
        return tenantConnect.searchTenant(regno);
    }

    public int deleteTenant(int regno, String reason) {
        return tenantConnect.deleteTenant(regno, reason);
    }

    public void update(int regno, String column, String data) {
        tenantConnect.updateTenant(regno, column, data);
    }

    public void updateOut(int regno) {
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formatTime = time.format(formatter);
        int res=tenantConnect.updateTenantOut(regno, Date.valueOf(date), formatTime);
        if(res>=1){
            Utility.showAlert("Tenant Outtime updateded sucessfully");
        }else
            Utility.showAlert("Try Again");
    }
}
