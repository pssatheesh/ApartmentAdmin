package Apartment.datas;

import Apartment.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDetails {
    private static PreparedStatement pst;
    private static ResultSet resultSet;
     private Connection connection;
    private DbCode Dbcode;

    public boolean isValidateCredential(String user, String pass) {
        boolean res=false;
        try{
            String q="select * from credentials where username=? and password=?";
            connection= DbCode.getConnection();
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
            Utility.showAlert( "Error: "+e);
        }
        return res;
    }

    public boolean isValidateUser(String user) {
        try{
            String q="select * from credentials where username=?";
            connection=Dbcode.getConnection();
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
