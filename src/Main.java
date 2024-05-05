import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection;
         String url="jdbc:mysql://localhost:3306/election";
         String user="root";
        String pass="satheesh";
        try{
            connection= DriverManager.getConnection(url, user, pass);
            for(int i=151;i<=200;i++){
                if(i%7==0){
                    String q="insert into voting_list ( Voter_Id, Party_Id, Constituency_Id, District_Id) values(?,?,?,?)";
                    PreparedStatement pst=connection.prepareStatement(q);
                    pst.setInt(1,i);
                    pst.setString(2, "NTK");
                    pst.setString(3, "C04");
                    pst.setString(4, "D03");

                    int c= pst.executeUpdate();
                }else if(i%3==0){
                    String q="insert into voting_list ( Voter_Id, Party_Id, Constituency_Id, District_Id) values(?,?,?,?)";
                    PreparedStatement pst=connection.prepareStatement(q);
                    pst.setInt(1,i);
                    pst.setString(2, "BJP");
                    pst.setString(3, "C04");
                    pst.setString(4, "D03");

                    int c= pst.executeUpdate();
                }else if(i%2==0){
                    String q="insert into voting_list ( Voter_Id, Party_Id, Constituency_Id, District_Id) values(?,?,?,?)";
                    PreparedStatement pst=connection.prepareStatement(q);
                    pst.setInt(1,i);
                    pst.setString(2, "AIADMK");
                    pst.setString(3, "C04");
                    pst.setString(4, "D03");

                    int c= pst.executeUpdate();
                }else {
                    String q="insert into voting_list ( Voter_Id, Party_Id, Constituency_Id, District_Id) values(?,?,?,?)";
                    PreparedStatement pst=connection.prepareStatement(q);
                    pst.setInt(1,i);
                    pst.setString(2, "DMK");
                    pst.setString(3, "C04");
                    pst.setString(4, "D03");
                    int c= pst.executeUpdate();
                }
            }



        }catch (SQLException e){
            System.out.println("Error: "+e);
        }


    }
}