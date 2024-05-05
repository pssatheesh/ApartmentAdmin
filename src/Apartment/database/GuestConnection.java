package Apartment.database;

import Apartment.models.Guest;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestConnection extends DbCode{
    public static boolean addGuest(String vehicle, String block, String house, Date date, String time, String parking, String reason) {
        try{
            String q="insert into guestdetails (Vehicle_details,Block,House_NO,Indate,Intime,Parking_slot,Reason) values(?,?,?,?,?,?,?)";
            pst=connection.prepareStatement(q);
            pst.setString(1,vehicle);
            pst.setString(2, block);
            pst.setString(3, house);
            pst.setDate(4, date);
            pst.setString(5, time);
            pst.setString(6, parking);
            pst.setString(7, reason);
            int c= pst.executeUpdate();
            if(c>=1){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
        }
        return false;
    }

    public static Guest searchGuest(String vehicle) {
        try{
            String q="select * from guestdetails where Vehicle_details=?";
            pst=connection.prepareStatement(q);
            pst.setString(1,vehicle);
            resultSet=pst.executeQuery();
            if(resultSet.next()){
               return gcreateObject();
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return null;
    }
    public static List<Guest> viewAllGuest() {
        try{
            String q="select * from guestdetails";
            pst=connection.prepareStatement(q);
            resultSet=pst.executeQuery();
            guestDetails=new ArrayList<>();
            while(resultSet.next()){
                guestDetails.add(gcreateObject());
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return guestDetails;
    }

    public static int updateGuestOut(String vehicle, Date date, String formatTime) {
        int n=0;
        try{
            String q="update guestdetails set Outdate=?, Outtime=? where Vehicle_details=?";
            pst=connection.prepareStatement(q);
            pst.setDate(1,date);
            pst.setString(2,formatTime);
            pst.setString(3,vehicle);
            n=pst.executeUpdate();
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return n;
    }
    private static Guest gcreateObject() throws Exception{
        int id=resultSet.getInt("S_No");
        String Vehicle_details=resultSet.getString("Vehicle_details");
        String block=resultSet.getString("Block");
        String house=resultSet.getString("House_NO");
        Date indate=resultSet.getDate("Indate");
        String intime=resultSet.getString("Intime");
        Date outdate=resultSet.getDate("Outdate");
        String outtime=resultSet.getString("Outtime");
        String parking=resultSet.getString("Parking_slot");
        String reason=resultSet.getString("Reason");
        guest=new Guest(id, Vehicle_details,block,house,indate,intime,outdate,outtime,parking,reason);
        return guest;
    }
}
