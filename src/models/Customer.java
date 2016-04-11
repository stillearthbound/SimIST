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
import java.awt.*;
public class Customer extends Rectangle{
    
    private String name;
    private String gender;
    private String[] animation;
    
    public Customer()
    {
        animation = new String [] {"right1.png" , "right2.png" , "left1.png" , "left2.png" , "up1.png" , "up2.png" , "down1.png" , "down2.png"};
        height = 75;
        width = 25;
    }
    
    
    public String[] getAnimation()
    {
        return animation;
    }
}
