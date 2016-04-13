/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import entities.Room;
import models.Customer;
import models.CharacterMovement;
import controllers.FloorController;

/**
 *
 * @author matthewtucker
 */
public class Floor extends JPanel implements ActionListener, KeyListener {
   private String floorName;
   private Image floorImage;
   //private Timer refreshTimer;
   private FloorController controller;
   //private ArrayList<Room> rooms;
   //private ArrayList<roomEntry> entries;
   //private player player1;
   //private abpEntry entry1;
  // private AuBonPainPanel abp1;
   //private Customer cust1;
   //private CharacterMovement charMove1;
   
   public Floor(String floorName, FloorController controller){
       //refreshTimer = new Timer (50, this);
      // refreshTimer.start();
       this.floorName = floorName;
       //this.floorImage = floorImage;
       this.controller = controller;
       //rooms = new ArrayList<>();
       //entries = new ArrayList<>();
       //rooms.add(new Room(201));
       //rooms.add(new Room (301));
      // entries.add(new roomEntry(201,50,50,rooms.get(0)));
       //player1 = new player();
       //cust1 = new Customer();
       //charMove1 = new CharacterMovement(cust1);
       //abp1 =new AuBonPainPanel(cust1, charMove1);
       //entry1 = new abpEntry(1, 100,100,abp1);
       this.addKeyListener(this);
       setFocusable(true);
       requestFocusInWindow();
   }
   
   
   public String getFloorName(){
       return this.floorName;
   }
   
   public void setFloorName(String name){
       this.floorName = name;
   }
   
   public void setImage (Image newImage){
       this.floorImage = newImage;
   }
   
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        
        
        
        
    }
   
   public void actionPerformed(ActionEvent e){
       
   }  
    public void keyPressed(KeyEvent e){
       
    }   
    
    public void keyReleased(KeyEvent e){
      
    }
    public void keyTyped(KeyEvent e){
        
    }
    
    public void addPlayerToFloor(){
        
    }
    
    public FloorController getCont(){
        return this.controller;
    }
    
    
   
   
    
    
    
    
    
    
   
   
   
   
   
   

}
