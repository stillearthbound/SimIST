package sandbox;
import java.net.*;
import java.io.*;
import java.util.*;
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
        String[] weatherCodes = {"tornado","tropical storm","hurricane","severe thunderstorms","thunderstorms","mixed rain and snow","mixed rain and sleet"
                ,"mixed snow and sleet","freezing drizzle","drizzle","freezing rain","showers","showers","snow flurries","light snow showers","blowing snow","snow","hail","sleet"
                        ,"dust","foggy","haze","smoky","blustery","windy","cold","cloudy","mostly cloudy (night)","mostly cloudy (day)","partly cloudy (night)","partly cloudy (day)"
                        ,"clear (night)","sunny","fair (night)","fair (day)","mixed rain and hail","hot","isolated thunderstorms","scattered thunderstorms","scattered thunderstorms"
                                ,"scattered showers","heavy snow","scattered snow showers","heavy snow","partly cloudy","thundershowers","snow showers","isolated thundershowers"};
        
        
        
        URL weather = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22statecollege%2C%20pa%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
        URLConnection yc = weather.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine=in.readLine();
        

         //   System.out.println(inputLine);
        int code = Integer.parseInt(inputLine.substring(119,121));    
        System.out.println(weatherCodes[(code + 1)]);  
        System.out.println(inputLine.substring(170,172) + "°F");  
        
        in.close();
        
        
       
        } 

    }

