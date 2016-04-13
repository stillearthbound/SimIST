package controllers;

/**
 * Interim Person class, representing a mobile person, which is also a Unit.
 * @author lvw5264
 */
public class Person extends Unit {
    protected Floor destFloor;
    
    public Person(String name, Floor floor) {
        super(name, floor);
        this.destFloor = floor; // the person is already where they want to be
    }
    
    // find where the passenger wants to go.
    public Floor getDestFloor() {
        return this.destFloor;
    }
    
    // change where the passenger wants to go.
    public void setDestFloor(Floor destFloor) {
        this.destFloor = destFloor;
    }
}
