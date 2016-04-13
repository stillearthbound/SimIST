/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Paul
 */
import java.util.*;
import java.util.ArrayList;

public class CharacterInventory {

    private ArrayList<StoreObjects> inventoryObjects;
    private ArrayList<Float> costs;
    private Map<String, Integer> map;

    public CharacterInventory() {
        inventoryObjects = new ArrayList<>();
        costs = new ArrayList<>();
        inventoryObjects.add(new StoreObjects("Used Napkin", 0.0f, 1));
        this.map = new HashMap<>();
    }

    public ArrayList<StoreObjects> getInventoryObjects() {
        return inventoryObjects;
    }

    public void addItem(StoreObjects item, double inf_quantity) {
        int quantity = (int) inf_quantity;
        if (quantity > 0) {
            if (map.get(item.getName()) != null && map.get(item.getName()) > 0) {
                
                map.put(item.getName(), map.get(item.getName()) + quantity);
                
            } else {

                map.put(item.getName(), quantity);
                for (int i = 0; i < quantity; i++) {
                    inventoryObjects.add(item);
                    costs.add(quantity*item.getCost());
                }
            }
        }
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void updateInventory() {

    }
    
    public ArrayList<Float> getCosts(){
        return costs;
    }

}
