package Apartment.database;

import Apartment.models.Guest;
import Apartment.models.Register;
import Apartment.models.Tenant;

import java.sql.*;
import java.util.List;

public class DbCode {
    public static DbCode dbCode;
    protected static Connection connection;
    protected String url="jdbc:mysql://localhost:3306/apartment";
    protected String user="root";
    protected String pass="satheesh";
    protected static PreparedStatement pst;
    protected static ResultSet resultSet;
    protected static Guest guest;
    protected static Tenant tenant;
    protected static Register register;
    protected static List<Guest> guestDetails;
    protected static List<Tenant> tenantDetails;
    protected static List<Register> registerDetails;


    public DbCode() {
        try{
            connection= DriverManager.getConnection(url, user, pass);
        }catch (SQLException e){
            System.out.println("Error: "+e);
        }
    }
    public static DbCode getInstance(){
        if(dbCode==null){
            dbCode=new DbCode();
        }
        return dbCode;
    }

    public boolean isValidateCredential(String user, String pass) {
        boolean res=false;
        try{
            String q="select * from credentials where username=? and password=?";
            pst=connection.prepareStatement(q);
            pst.setString(1,user);
            pst.setString(2, pass);
            resultSet= pst.executeQuery();
            if (resultSet.next()){
                if (resultSet.getString("password").equals(pass)){
                    return true;
                }
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
            e.printStackTrace();
        }
        return res;
    }

    public boolean isValidateUser(String user) {
        try{
            String q="select * from credentials where username=?";
            pst=connection.prepareStatement(q);
            pst.setString(1,user);
            resultSet= pst.executeQuery();
            if(resultSet.next()){
                return true;
            }

        }catch (SQLException e){
            System.out.println("Error: "+e);
        }
        return false;
    }
}
