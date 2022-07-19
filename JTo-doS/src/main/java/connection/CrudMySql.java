package connection;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CrudMySql extends ConnectToMySql{
    private common.Cache cache;
    
    protected void setCache(common.Cache cache){
        this.cache = cache;
    }
    
    protected void getQuery(String query, DefaultTableModel newTable){
        try{
            ResultSet rs = super.getConnection(cache).prepareStatement(query).executeQuery();
            
            //Add columns
            for(int Column = 0; Column < rs.getMetaData().getColumnCount(); Column++){
                newTable.addColumn(rs.getMetaData().getColumnName(Column + 1));
            }
            
            Object row[] = new Object[rs.getMetaData().getColumnCount()];
            
            //Add rows
            while(rs.next()){
                for(int Column = 0; Column < row.length; Column++){
                    row[Column] = rs.getObject(Column + 1);
                }
                
                newTable.addRow(row);
            }
        }catch(SQLException e){}
    }
    
    protected void setQuery(String query){
        try{
            super.getConnection(cache).prepareStatement(query).executeUpdate();
        }catch(SQLException e){}
    }
}