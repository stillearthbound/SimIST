/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event; //i have no idea why it doesnt like "event"
import java.lang.Object;// i dont know what this and the next line do, but its for the timer
import javax.swing.*;
/**
 *
 * @author Laura
 */
public class BuildingHVAC {
    public double outsideTemp;
    private boolean heat;
    private boolean ac;
    private double setRoomTemp;
    public double currentRoomTemp;
    private double tempChange;
    
    private int delay;
    private ActionListener listener;
//    public Timer time=new Timer(delay, listener); //timer is created in constructor. this one is not needed
    
    public BuildingHVAC(double outsideTemp){
        this.outsideTemp= outsideTemp;
        setRoomTemp=60.0;
        this.currentRoomTemp=this.outsideTemp; 
        //TODO does this refresh every time? can i change currentTemp & not outsideTemp?
        //also: how do i use the TODO tag? 
        this.tempChange=(setRoomTemp-this.outsideTemp);
        
        if(tempChange>0){
            heat();
        }
        else if(tempChange<0){
            ac();
        }
        listener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(tempChange>0){
                   heat();
                }
                else if(tempChange<0){
                    ac();
                }
            }
        };
        Timer timer=new Timer(delay, listener);
        timer.start();
        while(this.currentRoomTemp==setRoomTemp){
            timer.stop();
        }
    }
    
    public void heat(){
        this.currentRoomTemp++;
    }
    
    public void ac(){
        this.currentRoomTemp--;
    }
    
//    public double runTimer()
    
}
