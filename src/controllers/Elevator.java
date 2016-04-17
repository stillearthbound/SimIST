
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
    // pick up all passengers going in the same direction
    public void pickUp() {

    }

    // drop off all passengers that want to go to the current floir
    public void dropOff() {

    }
    */

    // move to the top floor
    public void moveUp(Person passenger) {
        // check if the bottom floor actually contains the passenger
        if (bottom.getUnitList().contains(passenger)) {
            // move passenger to another floor
            bottom.removeUnit(passenger);
            top.addUnit(passenger);
        }
    }

    // move to the bottom floor
    public void moveDown(Person passenger) {
        // check if the top floor actually contains the passenger
        if (top.getUnitList().contains(passenger)) {
            // move passenger to another floor
            top.removeUnit(passenger);
            bottom.addUnit(passenger);
        }
    }

    public Boolean canMoveUp() {
        if (currentFloor.getLevel() == super.top.getLevel()) { // on top floor
            return false; // could not move up since elevator at top floor
        } else {
            return true; // true means you can
        }
    }

    public Boolean canMoveDown() {
        if (currentFloor.getLevel() == super.bottom.getLevel()) { // on bottom floor
            return false; // could not move down since elevator at bottom floor
        } else {
            return true;
        }
    }

    // moves the whole elevator: setup only for three floors
    public Boolean up() {
        if (canMoveUp()) { // on top floor
            return false; // could not move up since elevator at top floor
        } else if (currentFloor.getLevel() == 2-1) { // on middle floor
            currentFloor = super.building.getFloor(3-1);
        } else if (currentFloor.getLevel() == 1-1) { // on bottom floor
            currentFloor = super.building.getFloor(2-1);
        }
        return true; // true means movement is successful
    }

    // moves the whole elevator: setup only for three floors
    public Boolean down() {
        if (canMoveDown()) { // on bottom floor
            return false; // could not move down since elevator at bottom floor
        } else if (currentFloor.getLevel() == 2-1) { // on middle floor
            currentFloor = super.building.getFloor(1-1);
        } else if (currentFloor.getLevel() == 3-1) { // on bottom floor
            currentFloor = super.building.getFloor(2-1);
        }
        return true;
    }

    public void move(int floorChoice) {
        if(currentFloor.getLevel() < floorChoice && canMoveUp()) {
            System.out.println("Going up..");
            currentFloor.setLevel(floorChoice);
            this.up();
            // dropOff();
            // pickUp();
        }
        else if(currentFloor.getLevel() > floorChoice && canMoveDown()) {
            System.out.println("Going down..");
            currentFloor.setLevel(floorChoice);
            this.down();
            // dropOff();
            // pickUp();
        }
    }
}
