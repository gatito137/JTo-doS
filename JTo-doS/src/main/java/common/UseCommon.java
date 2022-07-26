package common;

import java.awt.HeadlessException;

public class UseCommon {
    public final Cache cache = new Cache();
    public final StringBuilder query = new StringBuilder();
    public final bridge.Requests execute = new bridge.Requests(cache);
    
    public void msg(String Message){
        javax.swing.JOptionPane.showMessageDialog(null, Message);
    }
    public int confirm(String Message){
        return javax.swing.JOptionPane.showConfirmDialog(null, Message, "", javax.swing.JOptionPane.OK_OPTION);
    }
    
    public int getNat(String Value, int Error){
        try{
            Error = Integer.parseInt(Value);
            
            if(Error < 0){
                Error = Error * -1;
            }
        }catch(NumberFormatException e){}
        
        return Error;
    }
    
    public String getCleanText(String Text){
        String Nope[] = {"insert into", "update", "'", String.valueOf((char)34), "/"};
        
        for (String Texte : Nope) {
            Text = Text.replaceAll(Texte, "");
        }
        
        return Text.trim();
    }
    
    public String input(String Message, String Value){
        try{
            Message = getCleanText(javax.swing.JOptionPane.showInputDialog(Message, Value));
        }catch(HeadlessException e){
            Message = "";
        }
        
        return Message;
    }
}