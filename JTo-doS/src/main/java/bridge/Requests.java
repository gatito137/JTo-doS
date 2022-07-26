package bridge;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Requests extends connection.CrudMySql{
    private final DefaultTableModel Buffer = new DefaultTableModel();
    
    public Requests(common.Cache cache){
        super.setCache(cache);
    }
    
    public DefaultTableModel getTable(String query){
        Buffer.setRowCount(0);
        Buffer.setColumnCount(0);
        
        super.getQuery(query, Buffer);
        
        return Buffer;
    }
    
    public void fillList(String query, JComboBox List){
        Buffer.setRowCount(0);
        Buffer.setColumnCount(0);
        List.removeAllItems();
        List.addItem("");
        
        super.getQuery(query, Buffer);
        
        for(int row = 0; row < Buffer.getRowCount(); row++){
            List.addItem(Buffer.getValueAt(row, 0));
        }
    }
    
    public int getNat(String query, int Error){
        Buffer.setColumnCount(0);
        Buffer.setRowCount(0);
        
        super.getQuery(query, Buffer);
        
        if(Buffer.getRowCount() == 0){
            return Error;
        }
        
        try{
            Error = Integer.parseInt(Buffer.getValueAt(0, 0).toString());
        }catch(NumberFormatException e){}
        
        return Error;
    }
    
    public String getVal(String query){
        Buffer.setColumnCount(0);
        Buffer.setRowCount(0);
        
        super.getQuery(query, Buffer);
        
        try{
            query = Buffer.getValueAt(0, 0).toString();            
        }catch(Exception e){
            query = "";
        }
        
        return query;
    }
    
    public void executeQuery(String query){
        super.setQuery(query);
    }
}
