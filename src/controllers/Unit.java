package controllers;

/**
 * Interim Unit class, representing a mobile object in the IST building.
 * @author lvw5264
 */
public class Unit {
    protected String name;
    protected Floor level;

    public Unit(String name, Floor level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }
}
