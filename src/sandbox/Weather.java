package sandbox;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jrimland
*/
public class Weather {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String[] weatherCodeString = {"tornado","tropical storm","hurricane","severe thunderstorms","thunderstorms","mixed rain and snow","mixed rain and sleet"
                ,"mixed snow and sleet","freezing drizzle","drizzle","freezing rain","showers","showers","snow flurries","light snow showers","blowing snow","snow","hail","sleet"
                        ,"dust","foggy","haze","smoky","blustery","windy","cold","cloudy","mostly cloudy","mostly cloudy","partly cloudy","partly cloudy"
                        ,"clear","sunny","fair","fair","mixed rain and hail","hot","isolated thunderstorms","scattered thunderstorms","scattered thunderstorms"
                                ,"scattered showers","heavy snow","scattered snow showers","heavy snow","partly cloudy","thundershowers","snow showers","isolated thundershowers"};
        
        boolean cloudy = false;
        boolean rain = false;
        boolean snow = false;
        boolean sunny =false;
        
                
        
        URL weather = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22statecollege%2C%20pa%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
        URLConnection yc = weather.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine=in.readLine();
        int weatherCode = Integer.parseInt(inputLine.substring(119,121));    
        int temp = Integer.parseInt(inputLine.substring(170,172));
        
       // System.out.println(inputLine);
        if ((weatherCode > 25 && weatherCode < 31 )|| weatherCode == 44){
            cloudy = true;
            
        }
        else if(weatherCode < 5 ||(weatherCode >7 && weatherCode < 13 )|| weatherCode == 17 || weatherCode ==35 || (weatherCode >36 && weatherCode < 41) || weatherCode == 45 || weatherCode == 47){
            rain = true;
        }
        else if(weatherCode > 4 && weatherCode < 8 || weatherCode >12 && weatherCode < 17 || weatherCode >40 && weatherCode < 44 || weatherCode == 46){
            snow = true;
        }
        else if(weatherCode > 22 && weatherCode < 26 || weatherCode > 30 && weatherCode < 35|| weatherCode == 36){
            sunny = true;
        }
        
        
        if (rain == true){
            System.out.println("Rainy"); 
            
        }
        else if(cloudy == true){
            System.out.println("Cloudy"); 
            
        }
        else if(snow == true){
            System.out.println("Snow"); 
            
        }
        else if(sunny == true){
            System.out.println("Sunny"); 
            
        }
        else{
            System.out.println("error"); 
        }
        System.out.println(temp + "°F"); 
        
        
        in.close();
        
        
    ImageIcon sunnyImage;
    ImageIcon cloudyImage;
    ImageIcon rainyImage;
    ImageIcon snowyImage;
    JLabel tempLable;
    JLabel weatherIcon;
    
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        tempLable = new JLabel();
        weatherIcon = new JLabel();
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);
        f.setResizable(false);
        f.add(p);
        p.add(tempLable);
        p.add(weatherIcon);
        sunnyImage = new ImageIcon("src/sandbox/Weather Images/unny.gif");
        cloudyImage = new ImageIcon("src/sandbox/Weather Images/Cloudy.gif");
        rainyImage = new ImageIcon("src/sandbox/Weather Images/Rainy.gif");
        snowyImage = new ImageIcon("src/sandbox/Weather Images/Snowy.gif");   
        if (rain == true){
        weatherIcon.setIcon(rainyImage);
        weatherIcon.setSize(80,80);
        }
        else if(cloudy == true){
        weatherIcon.setIcon(cloudyImage);
        weatherIcon.setSize(80,80);
        }
        else if(snow == true){
        weatherIcon.setIcon(snowyImage);
        weatherIcon.setSize(80,80);
        }
        else if(sunny == true){
        weatherIcon.setIcon(sunnyImage);
        weatherIcon.setSize(80,80);
        }
        else{
         weatherIcon.setText("ERROR");
        }
        tempLable.setText(temp + "°F"); 
        
        

    
       
        }

    }