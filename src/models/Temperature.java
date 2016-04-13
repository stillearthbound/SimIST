/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import sandbox.Clock;
import sandbox.Weather;
import java.time.*;
import java.time.temporal.*;


/**
 *
 * @author Alex
 */
public class Temperature {
    
    double outsideTemp; //the real world temp
   
    double temperature; // the game temp
    int timeOfDay; //in game time
    
    double tempIncrement = 2; //the max positive temperature change in 1 hour
    double tempDecrement = -3;
    double tempChange; //hold the chnage hour to hour.

    public Temperature(int time, String outsideTemp)
    {
     
     //this.time = timeOfDay; **this will parse the string from the clock class to get the in game time.
    
     //this.outsideTemp = outsideTemp; **there will be a line to parse the string from the weather class.
     this.getTemp();
    }
      
    private double getTemp() //randomized the temp in game 
    {
        
         switch(timeOfDay){
            case 0:tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 1: tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 2: tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 3: tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 4: tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 5: tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 6: tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 7: tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 8: tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 9: tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 10:tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 11:tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 12:tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 13:tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 14:tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 15:tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 16:tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 17:tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 18:tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 19:tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 20:tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 21:tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 22:tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 23:tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            
        }
         temperature = outsideTemp + tempChange;
         
         return temperature;
         
    }
    
    
    
    
}
