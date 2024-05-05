package Apartment.database;

import Apartment.models.DeletedRecords;
import Apartment.models.Tenant;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeletedConnection extends DbCode{
    private static DeletedRecords deletedRecords;
    private static List<DeletedRecords> deletedDetails;

    public static List<DeletedRecords> viewAllRecords() {
        try{
            String q="select * from deleteddetails";
            pst=connection.prepareStatement(q);
            resultSet=pst.executeQuery();
            deletedDetails=new ArrayList<>();
            while(resultSet.next()){
                deletedDetails.add(delcreateObject());
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return deletedDetails;
    }
    private static DeletedRecords delcreateObject() throws SQLException {
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
        String reason=resultSet.getString("Reason");
        deletedRecords=new DeletedRecords(id,regno,name,block,house,address,Vehicle_details,indate,intime,outdate,outtime,parking,reason);
        return deletedRecords;
    }

    public static DeletedRecords searchRecords(int regno) {
        try{
            String q="select * from deleteddetails where Register_No=?";
            pst=connection.prepareStatement(q);
            pst.setInt(1,regno);
            resultSet=pst.executeQuery();
            if(resultSet.next()){
                return delcreateObject();
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return null;
    }
}
