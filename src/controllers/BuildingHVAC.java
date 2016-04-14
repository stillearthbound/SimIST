/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import sandbox.Weather;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Object;
import javax.swing.*;
/**
 *
 * @author Laura
 */
public class BuildingHVAC implements ActionListener{
    public double outsideTemp;
    private boolean heat;
    private boolean ac;
    private double setIndoorTemp;
    private double setLowerBoundIndoorTemp;
    private double setUpperBoundIndoorTemp;
    public double currentIndoorTemp;
    private double tempChange;
    
    private int delay;
    private ActionListener listener;
//    private Weather weather=new Weather();
    
    public int peopleCount;
    
    public BuildingHVAC(double outsideTemp){
//        this.outsideTemp=weather.getTemp();
        this.outsideTemp=25;
        setIndoorTemp=60.0;
        setLowerBoundIndoorTemp=57;
        setUpperBoundIndoorTemp=63;
        this.currentIndoorTemp=this.outsideTemp; 
        //TODO: does this refresh every time? can i change currentTemp & not outsideTemp?
        this.tempChange=(setIndoorTemp-this.outsideTemp);
        
        delay=1000;
        Timer timer=new Timer(delay, this); //this = actionListener bc this class extends actionListener
        timer.start();
    }
    public void actionPerformed(ActionEvent evt) {
        double lastTemp=0;
        if(tempChange>0){
            if(this.currentIndoorTemp<setIndoorTemp){
                heat();
            }
            else if(this.currentIndoorTemp==this.setIndoorTemp){
                ac();
            }
            else if(this.currentIndoorTemp<setIndoorTemp){
                ac();
            }
        }
        else if(tempChange<0){
            ac();
        }
        System.out.println(this.currentIndoorTemp);
    }
//    public void resetOutsideTemp(){
//        this.outsideTemp=weather.getTemp();
//    }
    public void heat(){
        this.currentIndoorTemp++;
    }
    
    public void ac(){
        this.currentIndoorTemp--;
    }
    public double getCurrentIndoorTemp(){
        return currentIndoorTemp;
    }
    public void setPeopleCount(){
        //TODO: set people count
        //this number would determine an increase in temperature due to crowding. 
    }
   
}
