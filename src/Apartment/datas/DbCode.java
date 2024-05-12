package Apartment.datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCode {
    private static Connection connection=null;
    private DbCode(){ }
    public static Connection getConnection() throws SQLException {
        if(connection==null){
            String url="jdbc:mysql://localhost:3306/apartment";
            String user="root";
            String pass="satheesh";
            connection= DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
}
