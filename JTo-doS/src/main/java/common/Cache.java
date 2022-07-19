package common;

import java.sql.*;

public class Cache {
    private static Connection connection;
    
    public Connection getConnection(){
        return connection;
    }
    
    public void setConnection(Connection newConnection){
        Cache.connection = newConnection;
    }
}