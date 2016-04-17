/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;
import java.io.*;
import java.util.Arrays;
/**
 *
 * @author jakedotts
 */
public class KeyReader {
    
    private String consumerKey = "";
    private String consumerSecret = "";
    private String accessToken = "";
    private String accessTokenSecret = "";
    
    public KeyReader(){
    
        
        String file = "authKeys.txt";
    
        try{
            
            InputStream inStream = new FileInputStream(file); 
            InputStreamReader inStreamReader = new InputStreamReader(inStream);
            BufferedReader in = new BufferedReader(inStreamReader);
            
            String line;
            
            while ((line = in.readLine())!=null){
                
                String[] keyArray = line.split(",");
                
                consumerKey = keyArray[0];
                consumerSecret = keyArray[1];
                accessToken = keyArray[2];
                accessTokenSecret = keyArray[3];
                
                System.out.println(consumerKey+"\n"+consumerSecret+"\n"+accessToken+"\n"+accessTokenSecret+" \n *** ");
                
            }
            
            in.close(); 
        }       
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public String getConsumerKey(){
        return consumerKey;
    }
    public String getConsumerSecret(){
        return consumerSecret;
    }
    public String getAccessToken(){
        return accessToken;
    }
    public String getAccessTokenSecret(){
        return accessTokenSecret;
    }
    
}
