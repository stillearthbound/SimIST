
package controllers;

import java.util.ArrayList;

public class Elevator extends Mover {
    protected Floor top;
    protected Floor bottom;
    protected ArrayList<Unit> passengers = new ArrayList<Unit>();
    
    public Elevator(Building building, Floor top, Floor bottom) {
        super(building);
    }
    
    // move to the top floor
    public void moveUp(Unit passenger){
        // check if the bottom floor actually contains the passenger
        if(bottom.getUnitList().contains(passenger)) {
            // move passenger to another floor
            bottom.removeUnit(passenger);
            top.addUnit(passenger);
        }
    }
    
    // move to the bottom floor
    public void moveDown(Unit passenger){
        // check if the top floor actually contains the passenger
        if(top.getUnitList().contains(passenger)) {
            // move passenger to another floor
            top.removeUnit(passenger);
            bottom.addUnit(passenger);
        }
    }
}
