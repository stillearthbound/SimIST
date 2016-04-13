/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Room;
import java.awt.Graphics;
import java.awt.Rectangle;
import views.AuBonPainPanel;

/**
 *
 * @author matthewtucker
 */
public class RoomEntry extends Rectangle {
    private int roomNum;
       private int floor;
       private int capacity;
       private int xLocation;
       private int yLocation;
       private Room room1;
       //private JPanel roomView;
       
       public RoomEntry(int roomNum, int x, int y, Room room1 ){
           this.roomNum = roomNum;
           //this.roomView = roomView;
           this.xLocation = x;
           this.yLocation = y;
           this.capacity = 50;
           this.floor = 1;
           this.room1=room1;
           
           this.setBounds(this.xLocation, this.yLocation, 30, 30);
       }
       
       public void paintComponent(Graphics g){
           g.drawRect(x, y, 30, 30);
       }
       
       public int getNum(){
           return this.roomNum;
       }
       
       public Room getRoom(){
           return this.room1;
       }
   }
   
   
   

