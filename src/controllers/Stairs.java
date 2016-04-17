
package controllers;


public class Stairs extends Mover {

    public Stairs(Building building, Floor top, Floor bottom) {
        super(building);
    }

    // move to the top floor
    public void moveUp(Person passenger){
        // check if the bottom floor actually contains the passenger
        if(super.bottom.getUnitList().contains(passenger)) {
            // move passenger to another floor
            super.bottom.removeUnit(passenger);
            super.top.addUnit(passenger);
        }
    }

    // move to the bottom floor
    public void moveDown(Person passenger){
        // check if the top floor actually contains the passenger
        if(super.top.getUnitList().contains(passenger)) {
            // move passenger to another floor
            super.top.removeUnit(passenger);
            super.bottom.addUnit(passenger);
        }
    }
}
