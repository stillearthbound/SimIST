/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import sandbox.ISTTime;
import java.time.*;
import java.time.temporal.*;


/**
 *
 * @author Alex
 */
public class Temperature {
    
    double ousideTemp;
    double initialTemp;
    double initialRawTemp;
    LocalDateTime timeOfDay;
    double minTemp; //calculated in randomize temp mehtod
    double maxTemp; //calculated in randomize temp mehtod
    double tempIncrement = 2; //the max positive temperature change in 1 hour
    double tempDecrement = -3;
    double tempChange; //hold the chnage hour to hour.
    int month;
    final double JAN_AVG_TEMP = 34;
    final double FEB_AVG_TEMP = 38;
    final double MAR_AVG_TEMP = 46;
    final double APR_AVG_TEMP = 60;
    final double MAY_AVG_TEMP = 70;  // Temps from http://www.usclimatedata.com/climate/state-college/pennsylvania/united-states/uspa2543
    final double JUN_AVG_TEMP = 78;
    final double JUL_AVG_TEMP = 82;
    final double AUG_AVG_TEMP = 80;
    final double SEP_AVG_TEMP = 72;
    final double OCT_AVG_TEMP = 61;
    final double NOV_AVG_TEMP = 50;
    final double DEC_AVG_TEMP = 38;
    
    
           
    
    
    public Temperature(int month, LocalDateTime time)
    {
      
     this.month=month;
     this.timeOfDay= time;
     
     this.initializeTemp(month);
     this.randomizeTemp(initialRawTemp);
     
    }
    
    private void initializeTemp(int month)
    {
        switch(month){
            case 1: initialRawTemp = 34; break;
            case 2: initialRawTemp = 38; break;
            case 3: initialRawTemp = 46; break;
            case 4: initialRawTemp = 60; break;
            case 5: initialRawTemp = 70; break;
            case 6: initialRawTemp = 78; break;
            case 7: initialRawTemp = 82; break;
            case 8: initialRawTemp = 80; break;
            case 9: initialRawTemp = 72; break;
            case 10: initialRawTemp = 61; break;
            case 11: initialRawTemp = 50; break;
            case 12: initialRawTemp = 38; break;
            default: initialRawTemp = 59.1; //this is the avg temp year round in happy valley isn't that neat?
        }
    
    }
        
    private void randomizeTemp( double initialRawTemp)
    {
     minTemp = initialRawTemp - 30;  //these 30 degree temps represent the max swing giving the algo in 1 day a max range of + or - 6 degrees from the start
     maxTemp = initialRawTemp + 30;
        
    initialTemp= minTemp + (int)(Math.random() * ((maxTemp - minTemp) + 1));
    
    }
    
    private void getTemp()
    {
        
         tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1));
         
         switch(timeOfDay.get(CLOCK_HOUR_OF_DAY)){
            case 1: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 2: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 3: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 4: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 5: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 6: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 7: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 8: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 9: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 10: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 11: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 12: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 13: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 14: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 15: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 16: initialRawTemp = tempChange= (Double) (Math.random() * ((tempIncrement - 0)+1)); break;
            case 17: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 18: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 19: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 20: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 21: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 22: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 23: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            case 24: initialRawTemp = tempChange= (Double) (Math.random() * ((tempDecrement - 0)+1)); break;
            
        }
         
    }
    
    
    
    
}
