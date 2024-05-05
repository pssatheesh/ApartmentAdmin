package Apartment.database;

import Apartment.models.Register;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegisterConnection extends DbCode{
    public static boolean addDetails(String vehicle, LocalDate date, String formatTime) {
        try{
            int regno = 0;
            String name="";
            String q1="select Register_No,Name from tenantdetails where Vehicle_details=?";
            pst=connection.prepareStatement(q1);
            pst.setString(1, vehicle);
            resultSet= pst.executeQuery();
            if(resultSet.next()){
                regno=resultSet.getInt("Register_No");
                name=resultSet.getString("Name");
            }

            String q="insert into dailyregister(Register_No, Name, Vehicle_details, Outdate, Outtime) values(?,?,?,?,?)";
            pst=connection.prepareStatement(q);
            pst.setInt(1,regno);
            pst.setString(2, name);
            pst.setString(3, vehicle);
            pst.setDate(4, Date.valueOf(date));
            pst.setString(5,formatTime);
            int c=pst.executeUpdate();
            if(c>=1){
                return true;
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return false;
    }

    public static List<Register> viewRegistry() {
        try{
            String q="select * from dailyregister";
            pst=connection.prepareStatement(q);
            resultSet=pst.executeQuery();
            registerDetails=new ArrayList<>();
            while(resultSet.next()){
                registerDetails.add(rcreateObject());
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return registerDetails;
    }

    public static Register searchRegister(String vehicle) {
        try{
            String q="select * from dailyregister where Vehicle_details=?";
            pst=connection.prepareStatement(q);
            pst.setString(1,vehicle);
            resultSet=pst.executeQuery();
            if(resultSet.next()){
                return rcreateObject();
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return null;
    }

    public static int updateIntime(String vehicle, Date date, String formatTime) {
        int n=0;
        try{
            String q="update dailyregister set Indate=?, Intime=? where Vehicle_details=?";
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

    private static Register rcreateObject() throws SQLException {
        int s_No=resultSet.getInt("S_No");
        int regno=resultSet.getInt("Register_No");
        String name=resultSet.getString("Name");
        String Vehicle_details=resultSet.getString("Vehicle_details");
        Date outdate=resultSet.getDate("Outdate");
        String outtime=resultSet.getString("Outtime");
        Date indate=resultSet.getDate("Indate");
        String intime=resultSet.getString("Intime");
        register=new Register(s_No, regno, name, Vehicle_details, outdate, outtime, indate, intime);
        return register;

    }
}
