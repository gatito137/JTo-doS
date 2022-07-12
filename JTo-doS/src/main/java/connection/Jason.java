package connection;

import java.io.*;
import java.util. Scanner;

public class Jason {
    private final StringBuilder Jason = new StringBuilder();
    private final String cc = String.valueOf((char)34);
    private final StringBuilder Buffer = new StringBuilder();
    
    public Jason(String NameBD){
        connect(NameBD + ".txt");
    }
    
    private void connect(String NameBD){
        try{
            Scanner reader = new Scanner(new File(NameBD));
            
            while(reader.hasNextLine()){
                Jason.append(reader.nextLine());
            }
        }catch(FileNotFoundException e){}
    }
    
    public String getValue(String Value, String Error){      
        for(int i = 0; i < Jason.length() - Value.length(); i++){
            Buffer.delete(0, Buffer.length());
            
            if(Jason.toString().substring(i, i + Value.length()).equals(Value)){
                Buffer.append(Jason.toString().substring(i + 3 + Value.length()));
                return Buffer.toString().substring(0, Buffer.toString().indexOf(cc));
            }
        }
        
        return Error;
    }
    
    public int getNat(String Value, int Error){
        try{
            return Integer.parseInt(getValue(Value, String.valueOf(Error)));
        }catch(NumberFormatException e){
            return Error;
        }
    }
    
    public int getCount(String Field, String Value){
        int Counter = 0;
        
        for(int i = 0; i<Jason.length() - Field.length() - 3 - Value.length(); i++){
            if(Jason.toString().substring(i, i + 1).equals(cc)){
                Buffer.delete(0, Buffer.length());
                Buffer.append(Jason.toString().substring(i + 1));
                
                if(Buffer.toString().substring(0, Buffer.toString().indexOf(cc)).equals(Field)){
                    Buffer.delete(0, Buffer.length());
                    Buffer.append(Jason.toString().substring(i + 4 + Field.length()));
                    
                    if(Buffer.toString().substring(0, Buffer.toString().indexOf(cc)).equals(Value)){
                        Counter += 1;
                    }
                }
            }
        }
        
        return Counter;
    }
    
    public void clear(){
        Jason.delete(0, Jason.length());
        Jason.append("{");
    }
    
    public void add(String Field, String Value){
        if(Jason.length() > 1){
            Jason.append(",");
        }
        
        Jason.append(cc);
        Jason.append(Field);
        Jason.append(cc).append(":").append(cc);
        Jason.append(Value).append(cc);
    }
    
    public void export(String newName){     
        try{
            Jason.append("}");
            
            PrintWriter File = new PrintWriter(new BufferedWriter(new FileWriter(newName + ".txt")));
            File.println(Jason.toString());
            File.close();
        }catch(IOException e){}
    }
}
