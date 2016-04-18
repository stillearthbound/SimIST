/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public class Location {
    //private Floor floor;
    //Commented out floor attribute and methods because we are assuming floor will be associated with room.
    private Room room;
    private int xValue;
    private int yValue;
    //Assuming we will use tile based positions system.
        
    Location(/*Floor floor, */Room room, int xValue, int yValue){
        this.room = room;
        this.xValue = xValue;
        this.yValue = yValue;
        //this.floor = floor;
    }
    
    
    public Room getRoom(){
        return room;
    }
    
    
   /* public Floor getFloor(){
        return floor;
    }*/
    
    
    public void setRoom(Room room){
        this.room = room;
    }
    
    
    /*public void setFloor(Floor floor){
        this.floor = floor;
    }*/

    /**
     * @return the xValue
     */
    public int getxValue() {
        return xValue;
    }

    /**
     * @param xValue the xValue to set
     */
    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    /**
     * @return the yValue
     */
    public int getyValue() {
        return yValue;
    }

    /**
     * @param yValue the yValue to set
     */
    public void setyValue(int yValue) {
        this.yValue = yValue;
    }    
            
}
