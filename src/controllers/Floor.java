package controllers;


import java.util.ArrayList;


public class Floor {

    protected ArrayList<Unit> unitList = new ArrayList<Unit>();

    protected int level; // numerical level of the floor: negative is underground
    
    public Floor(int level) {
        this.level = level;
    }


    public void addUnit(Unit u) {
        this.unitList.add(u);
    }
    
    public void removeUnit(Unit u){
        this.unitList.remove(u);
    } 

    public ArrayList<Unit> getUnitList() {
        return this.unitList;
    }

    public void setUnitList(ArrayList<Unit> unitList) {
        this.unitList = unitList;
    }

    
    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
