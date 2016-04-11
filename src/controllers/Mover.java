package controllers;

import java.util.ArrayList;

public abstract class Mover {
    protected Building building;
    protected ArrayList<Floor> floors;

    public Mover(Building building) {
        this.building = building;
        ArrayList<Floor> floors = new ArrayList<Floor>();
    }

    public void addFloor(Floor f) {
        floors.add(f);
    }

    public void removeFloor(Floor f) {
        floors.remove(f);
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }
    
    //Needs to be overridden by child classes.
    public abstract void moveUp(Unit passenger);
    
    public abstract void moveDown(Unit passenger);
}