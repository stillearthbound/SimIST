/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.*;
import java.util.Random;

public class Randomize {
    private StoreObjects[] fruitObjects;
    private StoreObjects[] soupObjects;
    private StoreObjects[] coffeeObjects;
    private StoreObjects[] coolerObjects;
    private StoreObjects[] bakeryObjects;
    private Random rand = new Random();

    
    public Randomize(){
//        fruitObjects = new StoreObjects[]{ new Apples(rand.nextInt(20)) , new Bananas(rand.nextInt(20)) , new Oranges(rand.nextInt(20)) };
//        soupObjects = new StoreObjects[]{ new TomatoSoup(rand.nextInt(20)) , new BroccoliCheddarSoup(rand.nextInt(20)) , new ChickenNoodleSoup(rand.nextInt(20)) };
//        coffeeObjects = new StoreObjects[]{ new FrenchVanillaCoffee(rand.nextInt(20)) , new RegularCoffee(rand.nextInt(20)) , new SeasonalCoffee(rand.nextInt(20)) };
//        coolerObjects = new StoreObjects[]{ new CaesarSalad(rand.nextInt(20)) , new ChefSalad(rand.nextInt(20)) , new HamWrap(rand.nextInt(20)), new TurkeyWrap(rand.nextInt(20)) , new VeggieWrap(rand.nextInt(20)) };
//        bakeryObjects = new StoreObjects[]{ new Bagels(rand.nextInt(20)) , new Croissants(rand.nextInt(20)) , new Donuts(rand.nextInt(20)) };
        
        fruitObjects = new StoreObjects[]{ new StoreObjects("Apple",2.5f, rand.nextInt(20), "apple.png") , new StoreObjects("Banana",7.0f, rand.nextInt(20), "banana.png") , new StoreObjects("Orange",10.00f, rand.nextInt(20), "orange.png") };
        soupObjects = new StoreObjects[]{ new StoreObjects("Tomato Soup",6.0f, rand.nextInt(20), "tomatosoup.png") , new StoreObjects("Broccoli Cheddar Soup",6.0f, rand.nextInt(20), "broccolicheddarsoup.png") , new StoreObjects("Chicken Noodle Soup",6.0f, rand.nextInt(20), "soup.png") };
        coffeeObjects = new StoreObjects[]{ new StoreObjects("French Vanilla Coffee",2.50f, rand.nextInt(20), "coffee.png") , new StoreObjects("Regular Coffee",2.50f, rand.nextInt(20), "coffee.png") , new StoreObjects("Seasonal Coffee",2.50f, rand.nextInt(20), "coffee.png"), new StoreObjects("Napkin",.50f, rand.nextInt(50), "napkin.png"), new StoreObjects("Utensils",.75f, rand.nextInt(20), "utensils.png")};
        coolerObjects = new StoreObjects[]{ new StoreObjects("Caesar Salad",9.0f, rand.nextInt(20), "salad.png") , new StoreObjects("Chef Salad",12.5f, rand.nextInt(20), "salad.png") , new StoreObjects("Ham Wrap",8.5f, rand.nextInt(20), "sandwich.png"), new StoreObjects("Turkey Wrap",8.5f, rand.nextInt(20), "sandwich.png") , new StoreObjects("Veggie Wrap",9.5f, rand.nextInt(20), "sandwich.png") };
        bakeryObjects = new StoreObjects[]{ new StoreObjects("Bagel",3.5f, rand.nextInt(20), "bagel.png") , new StoreObjects("Croissant",5.0f, rand.nextInt(20), "croissant.png") , new StoreObjects("Donut",4.99f, rand.nextInt(20), "donut.png") };
    
        
        //Testing out possibility of using enums
        StoreObjects.ObjectType test = new StoreObjects("Apple",2.5f, rand.nextInt(20)).TYPE.APPLE;
        //System.out.println("APPLE COST: "+test.getCost());

    
    }

    /**
     * @return the fruitObjects
     */
    public StoreObjects[] getFruitObjects() {
        return fruitObjects;
    }

    /**
     * @return the soupObjects
     */
    public StoreObjects[] getSoupObjects() {
        return soupObjects;
    }

    /**
     * @return the coffeeObjects
     */
    public StoreObjects[] getCoffeeObjects() {
        return coffeeObjects;
    }

    /**
     * @return the coolerObjects
     */
    public StoreObjects[] getCoolerObjects() {
        return coolerObjects;
    }

    /**
     * @return the bakeryObjects
     */
    public StoreObjects[] getBakeryObjects() {
        return bakeryObjects;
    }
    
}
