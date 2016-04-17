package controllers;

import java.util.ArrayList;
import entities.*;
import views.*;

public class FloorController {
    private GameFrame frame1;
    private Floor1 floor1;
    private Room room1;
   
    
    public FloorController(){
        frame1 = new GameFrame("Test Room");
        floor1 = new Floor1("Floor", this);
        frame1.add(floor1);
        floor1.setFocusable(true);
        floor1.requestFocusInWindow();
    }

    //protected ArrayList<Unit> unitList = new ArrayList<Unit>();

//    public void addUnit(Unit u) {
//        this.unitList.add(u);
//    }
//    
//    public void removeUnit(Unit u){
//        this.unitList.remove(u);
//    } 
//
//    public ArrayList<Unit> getUnitList() {
//        return this.unitList;
//    }
//
//    public void setUnitList(ArrayList<Unit> unitList) {
//        this.unitList = unitList;
//    }
    
    public void floorToRoom(Room room1){
        frame1.remove(floor1);
        frame1.add(room1);
        this.room1 = room1;
        room1.setFocusable(true);
        room1.requestFocusInWindow();
        frame1.revalidate();
        frame1.repaint();
    }
    
    public void floorToAbp(AuBonPainPanel panel1){
        frame1.remove(floor1);
        frame1.add(panel1);
        //room1.setFocusable(true);
       // room1.requestFocusInWindow();
        frame1.revalidate();
        frame1.repaint();
    }
    
    public void roomToFloor(Floor1 floor)
    {
        frame1.remove(room1);
        frame1.add(floor);
        frame1.revalidate();
        frame1.repaint();
    }
            

}
