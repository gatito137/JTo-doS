package connection;

import java.sql.*;

public class ConnectToMySql {
    protected Connection getConnection(common.Cache cache){
        testConnection(cache);
        
        if(cache.getConnection() == null){
            try{
                String url = "jdbc:mysql://remotemysql.com:3306/ELclcK22Ce";
                String user = "ELclcK22Ce";
                String pass = "whz1XqsOYP";
                
                cache.setConnection(DriverManager.getConnection(url, user, pass));
            }catch(SQLException e){
                cache.setConnection(null);
            }
        }
        
        return cache.getConnection();
    }
    
    private void testConnection(common.Cache cache){
        if(cache.getConnection() == null){
            return;
        }
        
        try{
            cache.getConnection().prepareStatement("select 1;");
        }catch(SQLException e){
            cache.setConnection(null);
        }
    }
}