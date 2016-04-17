
package controllers;

import java.util.ArrayList;

public abstract class Mover {
    protected Building building;
    protected ArrayList<Floor> floorList;
    protected Floor top;         // top floor
    protected Floor bottom;      // bottom floor

    public Mover(Building building) {
        this.building = building;
        this.floorList = building.getFloorList();       // get all available floors in this building
        this.bottom = floorList.get(1 - 1);             // index starts at 0, so subtract 1
        this.top = floorList.get(floorList.size() - 1); // top floor is the maximum floor
    }

    public ArrayList<Floor> getFloors() {
        return this.floorList;
    }

    public Building getBuilding() {
        return this.building;
    }

    //Needs to be overridden by child classes.
    public abstract void moveUp(Person passenger);

    public abstract void moveDown(Person passenger);
}
