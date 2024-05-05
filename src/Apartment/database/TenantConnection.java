package Apartment.database;

import Apartment.models.Tenant;
import Apartment.util.Utility;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TenantConnection extends DbCode {

    public static boolean addTenant(int regno, String name, String block, String house, String address, String vehicle, Date date, String formatTime, String parkingSlot) {
        try{
            String q="insert into tenantdetails (Register_No,Name,Block,House_NO, Address,Vehicle_details, Indate, Intime,Parking_slot) values(?,?,?,?,?,?,?,?,?)";
            pst=connection.prepareStatement(q);
            pst.setInt(1,regno);
            pst.setString(2, name);
            pst.setString(3, block);
            pst.setString(4, house);
            pst.setString(5, address);
            pst.setString(6, vehicle);
            pst.setDate(7, date);
            pst.setString(8, formatTime);
            pst.setString(9, parkingSlot);
            int c= pst.executeUpdate();
            if(c>=1){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
        }
        return false;
    }
    public static List<Tenant> viewAllTenant() {
        try{
            String q="select * from tenantdetails";
            pst=connection.prepareStatement(q);
            resultSet=pst.executeQuery();
            tenantDetails=new ArrayList<>();
            while(resultSet.next()){
                tenantDetails.add(tcreateObject());
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return tenantDetails;
    }
    public static Tenant searchTenant(int regno) {
        try{
            String q="select * from tenantdetails where Register_No=?";
            pst=connection.prepareStatement(q);
            pst.setInt(1,regno);
            resultSet=pst.executeQuery();
            if(resultSet.next()){
              return tcreateObject();
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return null;
    }

    public static void updateTenant(int regno, String column, String data) {
        try{
            String q="update tenantdetails set "+column+" =? where register_no=?";
            pst=connection.prepareStatement(q);
            pst.setString(1,data);
            pst.setInt(2,regno);
            pst.executeUpdate();
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
    }

    public static int deleteTenant(int regno, String reason) {
        int n=0;
        try{
            if(insertToDeletedData(regno, reason)){
                String q="delete from tenantdetails where Register_No=?";
                pst=connection.prepareStatement(q);
                pst.setInt(1, regno);
                n=pst.executeUpdate();
            }else{
                Utility.showAlert("Data not inserted into deleted table");
                throw new RuntimeException("Data not inserted into deleted table");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return n;
    }

    private static boolean insertToDeletedData(int regno, String reason) {
        try{
            tenant=searchTenant(regno);
            String q="insert into deleteddetails (Register_No,Name,Block,House_NO, Address,Vehicle_details, Indate, Intime,Outdate, Outtime,Parking_slot,Reason) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=connection.prepareStatement(q);
            pst.setInt(1,regno);
            pst.setString(2, tenant.getName());
            pst.setString(3, tenant.getBlock());
            pst.setString(4, tenant.getHouse_No());
            pst.setString(5, tenant.getAddress());
            pst.setString(6, tenant.getVehicle_details());
            pst.setDate(7, (Date)tenant.getIndate());
            pst.setString(8, tenant.getIntime());
            pst.setDate(9, (Date)tenant.getOutdate());
            pst.setString(10, tenant.getOuttime());
            pst.setString(11, tenant.getParking_slot());
            pst.setString(12, reason);

            int c= pst.executeUpdate();
            if(c>=1){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
        }
        return false;

    }

    private static Tenant tcreateObject() throws SQLException {
        int id=resultSet.getInt("S_No");
        int regno=resultSet.getInt("Register_No");
        String name=resultSet.getString("Name");
        String block=resultSet.getString("Block");
        String house=resultSet.getString("House_NO");
        String address=resultSet.getString("Address");
        String Vehicle_details=resultSet.getString("Vehicle_details");
        Date indate=resultSet.getDate("Indate");
        String intime=resultSet.getString("Intime");
        Date outdate=resultSet.getDate("Outdate");
        String outtime=resultSet.getString("Outtime");
        String parking=resultSet.getString("Parking_slot");
        tenant=new Tenant(id,regno,name,block,house,address,Vehicle_details,indate,intime,outdate,outtime,parking);
        return tenant;
    }
}
