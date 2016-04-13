
package controllers;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Elevator extends Mover {
    protected int direction = 0; // -1 for down, 0 for no direction, 1 for up.
    protected Floor currentFloor;
    ArrayList<Person> passengers = new ArrayList<Person>();
    // which floors have the buttons activated
    
    public Elevator(Building building) {
        super(building);
        this.currentFloor = super.bottom; // rest position of elevator is always at the bottom
        this.direction = 0;         // elevator is at rest
    }
    
    // accessor for direction of elevator. no mutator given (outsiders shouldn't interfere with elevator motion)
    // -1 for down, 0 for no direction, 1 for up.
    public int getDirection() {
        return this.direction;
    }
    
    /*
    // primary method for the elevator
    public void move() {
        
    }
    
    // pick up all passengers going in the same direction
    public void pickUp() {
        
    }
    
    // drop off all passengers that want to go to the current floir
    public void dropOff() {
        
    }
    */
    
    // move to the top floor
    public void moveUp(Person passenger){
        // check if the bottom floor actually contains the passenger
        if(bottom.getUnitList().contains(passenger)) {
            // move passenger to another floor
            bottom.removeUnit(passenger);
            top.addUnit(passenger);
        }
    }
    
    // move to the bottom floor
    public void moveDown(Person passenger){
        // check if the top floor actually contains the passenger
        if(top.getUnitList().contains(passenger)) {
            // move passenger to another floor
            top.removeUnit(passenger);
            bottom.addUnit(passenger);
        }
    }
}
