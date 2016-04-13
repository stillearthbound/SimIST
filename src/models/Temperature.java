/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import sandbox.ISTTime;
import java.time.*;

/**
 *
 * @author Alex
 */
public class Temperature {
    
    double ousideTemp;
    double initialTemp;
    double initialRawTemp;
    LocalDateTime timeOfDay;
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
    }
    
    private double initializeTemp(String month)
    {
        switch(month){
            case "1": initialRawTemp = 34; break;
            case "2": initialRawTemp = 38; break;
            case "3": initialRawTemp = 46; break;
            case "4": initialRawTemp = 60; break;
            case "5": initialRawTemp = 70; break;
            case "6": initialRawTemp = 78; break;
            case "7": initialRawTemp = 82; break;
            case "8": initialRawTemp = 80; break;
            case "9": initialRawTemp = 72; break;
            case "10": initialRawTemp = 61; break;
            case "11": initialRawTemp = 50; break;
            case "12": initialRawTemp = 38; break;
            default: initialRawTemp = 59.1; //this is the avg temp year round in happy valley isn't that neat?
        }
    return initialTemp;
    }
        
    //private double RandomizeTemp(initialRawTemp)
    //{
    //return initialTemp
    //}
}
