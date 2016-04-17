package controllers;

import java.util.ArrayList;

/**
 *
 * @author antonizoon
 */
public class Building {
    protected ArrayList<Floor> floorList = new ArrayList<Floor>();

    // IST building has a preset amount of three floors for the elevator, so start with that by default
    public Building() {
        this.addFloor(new Floor(1)); // 1
        this.addFloor(new Floor(2)); // 2
        this.addFloor(new Floor(3)); // 3
    }

    // named levels: fine as we doubt that the IST building will add another elevator floor
    public Floor top() {
        return floorList.get(3 - 1);
    }

    public Floor middle() {
        return floorList.get(2 - 1);
    }

    public Floor bottom() {
        return floorList.get(1 - 1);
    }

    // get floor by level, first floor is 0
    public Floor getFloor(int level) {
        return floorList.get(level);
    }

    public void addFloor(Floor u) {
        this.floorList.add(u);
    }

    public void removeFloor(Floor u){
        this.floorList.remove(u);
    }

    public ArrayList<Floor> getFloorList() {
        return this.floorList;
    }

    public void setFloorList(ArrayList<Floor> floorList) {
        this.floorList = floorList;
    }
}
