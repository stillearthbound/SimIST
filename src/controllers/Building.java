/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;

/**
 *
 * @author lvw5264
 */
public class Building {
    // a building has an arraylist of available floors
    protected ArrayList<Floor> floors = new ArrayList<Floor>();
    
    public void addFloor(Floor u) {
        this.floors.add(u);
    }
    
    public void removeFloor(Floor u){
        this.floors.remove(u);
    } 

    public ArrayList<Floor> getFloorList() {
        return this.floors;
    }

    public void setFloorList(ArrayList<Floor> floors) {
        this.floors = floors;
    }
    
}
