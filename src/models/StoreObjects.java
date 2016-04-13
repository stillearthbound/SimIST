/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.*;
/**
 *
 * @author greg
 */
public class StoreObjects {
    
    protected String name;
    protected float cost;
    protected int quantity;
    protected boolean paidFor;
    protected ObjectType TYPE;
    
    
    
    public StoreObjects()
    {
        
    
   
    }
    public StoreObjects(String inf_name, float inf_cost, int inf_quantity)
    {
        name = inf_name;
        cost = inf_cost;
        quantity = inf_quantity;
        paidFor = false;
    }
    
   public String getName()
   {
       return name;
   }
   
   public float getCost()
   {
       return cost;
   }
    
   public int getQuantity()
   {
       return quantity;
   }
   
   public void setQuantity(int set)
   {
       quantity = set;
   }
   
   public boolean getPaidFor()
   {
       return paidFor;
   }
   
   public void setPaidFor(boolean set)
   {
       paidFor = set;
       
       
   }
   
   
   
   //Testing out possibility of using enums
   public enum ObjectType {
    
    
    
    APPLE("Apple",2.50f,10, false),
    BANANA("Banana",2.50f,10,false);
    
    

    private final String name;
    private float cost;
    private int quantity;
    private boolean isPurchased;

    private ObjectType(String full, float cost, int quantity, boolean isPurchased) {
        this.name = full;
        this.cost = cost;
        this.quantity = quantity;
        this.isPurchased = isPurchased;
    }

    public String Name() {
        return name;
    }

    public float getCost()
    {
        return cost;
    }

    public int getQuantity()
    {
        return quantity;
    }
    
    public boolean getIsPurchased()
    {
        return isPurchased;
    }
    
    public void setCost(float set)
    {
        cost = set;
    }
   
    public void setQuantity(int set)
    {
        quantity = set;
    }
    
    public void setIsPurchased(boolean set)
    {
        isPurchased = set;
    }
    
}
   
   
}






