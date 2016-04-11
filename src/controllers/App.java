package controllers;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jrimland
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a test building and it's floors
        Building ist = new Building();
        ist.addFloor(new Floor(1));
        ist.addFloor(new Floor(2));
        ist.addFloor(new Floor(3));
        
        // create an example unit on floor 1
        Unit item = new Unit("Example Unit", floor1);
        Person person = new Person("Example Person", floor1);
        System.out.println(item.getName());
        System.out.println(person.getName());
        
        // display all elements in the arraylist
        ArrayList<Unit> pplOnFlr = floor1.getUnitList();
        for (Unit unit : pplOnFlr) {
            System.out.println(unit.getName());
        }
    }
    
}
