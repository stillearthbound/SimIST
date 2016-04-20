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
    
    private String[] animations;
    private String animation = "left1.png";
    private CharacterInventory inventory;
    
    public Customer(Dimension inf_FrameSize)
    {
        animations = new String [] {"right1.png" , "right2.png" , "left1.png" , "left2.png" , "up1.png" , "up2.png" , "down1.png" , "down2.png"};
        inventory = new CharacterInventory();
        double tempHeight = inf_FrameSize.height * .125;
        double tempWidth = inf_FrameSize.width * .05;
        double tempX = inf_FrameSize.width * .875;
        double tempY = inf_FrameSize.height * .666;
        height = (int) tempHeight;
        width = (int) tempWidth;
        x = (int) tempX;
        y = (int) tempY;
    }
    
    public CharacterInventory getInventory()
    {
        return inventory;
    }
    
    
    public String[] getAnimations()
    {
        return animations;
    }
    
    public String getAnimation()
    {
        return animation;
    }
    
    public void setAnimation(String set)
    {
        animation = set;
    }
}
