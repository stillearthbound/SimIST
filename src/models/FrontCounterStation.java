/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author greg
 */
public class FrontCounterStation extends FoodStations{
    protected String stationName = "Front Counter";
    protected int quantity = -1;
    protected String name = null;
    protected float cost = (float)-1.0;
    
    public FrontCounterStation(){
        this.quantity = quantity;
        this.name = name;
        this.cost = cost;
    }
}
