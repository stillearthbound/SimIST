package controllers;

<<<<<<< Updated upstream
import java.util.ArrayList;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import views.*;
>>>>>>> Stashed changes

public class Floor {

    protected ArrayList<Unit> unitList = new ArrayList<Unit>();
<<<<<<< Updated upstream
    protected int level; // numerical level of the floor: negative is underground
    
    public Floor(int level) {
        this.level = level;
    }
=======
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
    
    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
=======


>>>>>>> Stashed changes
}
