/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Graham
 */
public class Hallway extends JPanel implements ActionListener, KeyListener{
    private ArrayList<Table> tables;
    private ArrayList<Divider> dividers;
    private ArrayList<Trashcan> trashcans;
    private Player1 player1;
    private GameFrame1 theFrame;
    private Timer timer1;
    
    public Hallway(){
       super();
       this.addKeyListener(this);
       this.player1 = new Player1(500, 500);
       this.theFrame = new GameFrame1(this);
       this.setFocusable(true);
       this.dividers = new ArrayList<Divider>();
       this.tables = new ArrayList<Table>();
       this.trashcans = new ArrayList<>();
       populateObjects();
       this.timer1 = new Timer(50, this);
       this.timer1.start();
       
    }
    
    private void  populateObjects(){
        Table table1 = new Table(50, 100, 400, 50, "Table 1");
        Table table2 = new Table(50, 100, 400, 200, "Table 2");
        Table table3 = new Table(50, 100, 400, 350, "Table 3");
        Divider divider1 = new Divider(150, 10, 350, 25, "Divider 1");
        Divider divider2 = new Divider(150, 10, 350, 170, "Divider 2");
        Divider divider3 = new Divider(150, 10, 350, 315, "Divider 3");
        Trashcan trashcan1 = new Trashcan(30, 125, 0, 175, "Trashcan");
        
        trashcans.add(trashcan1);
        
        dividers.add(divider1);
        dividers.add(divider2);
        dividers.add(divider3);
        
        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.clearRect(0, 0, this.getWidth(), this.getHeight());
       player1.paintComponenet(g);
       paintObjects(g);
          
        
    }
    
     public void paintObjects(Graphics g){
      for(int i = 0; i<tables.size(); i++)
       {
           tables.get(i).paintComponent(g);
       }
      for(int i = 0; i<dividers.size(); i++)
       {
           dividers.get(i).paintComponent(g);
       }
      for(int i = 0; i<trashcans.size(); i++)
       {
           trashcans.get(i).paintComponent(g);
       }
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if(o== timer1){
            this.repaint();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player1.keyPressed(e);
        System.out.println("Hi");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1.keyReleased(e);
    }

    /**
     * @return the tables
     */
    public ArrayList<Table> getTables() {
        return tables;
    }

    /**
     * @param tables the tables to set
     */
    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    /**
     * @return the dividers
     */
    public ArrayList<Divider> getDividers() {
        return dividers;
    }

    /**
     * @param dividers the dividers to set
     */
    public void setDividers(ArrayList<Divider> dividers) {
        this.dividers = dividers;
    }

    /**
     * @return the trashcans
     */
    public ArrayList<Trashcan> getTrashcans() {
        return trashcans;
    }

    /**
     * @param trashcans the trashcans to set
     */
    public void setTrashcans(ArrayList<Trashcan> trashcans) {
        this.trashcans = trashcans;
    }

    /**
     * @return the player1
     */
    public Player1 getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(Player1 player1) {
        this.player1 = player1;
    }

    /**
     * @return the theFrame
     */
    public GameFrame1 getTheFrame() {
        return theFrame;
    }

    /**
     * @param theFrame the theFrame to set
     */
    public void setTheFrame(GameFrame1 theFrame) {
        this.theFrame = theFrame;
    }

    /**
     * @return the timer1
     */
    public Timer getTimer1() {
        return timer1;
    }

    /**
     * @param timer1 the timer1 to set
     */
    public void setTimer1(Timer timer1) {
        this.timer1 = timer1;
    }
    
    
    
    
    
}



class Table extends Rectangle{
    private int dy;
    private final Dimension size;
    private Image tableImage;
   
    private String deskID;
    
    
    public Table(int panelHeight, int panelWidth,int deskx,int desky, String Name) {
        
        
        this.deskID = Name;
        this.size = new Dimension(panelWidth, panelHeight);
        this.setBounds(deskx, desky, panelHeight, panelWidth);  
      
    }
    
    
    public void paintComponent(Graphics g){
        move();
        g.setColor(Color.DARK_GRAY);
        g.draw3DRect(this.x, this.y, this.width, this.height, true);
        g.fill3DRect(x, y, width, height, true);
    }
    
    public double getCurrentX() {
        return super.getX();
    }
    
    public double getCurrrentY() {
        return super.getY();
    }
    
  
    public void move() {
        
        
    }
    
}



class Divider extends Rectangle{
    private int dy;
    private final Dimension size;
    private Image dividerImage;
    
    private String deskID;
    
    
    public Divider(int panelHeight, int panelWidth,int deskx,int desky, String Name) {
        
        
        this.deskID = Name;
        this.size = new Dimension(panelWidth, panelHeight);
        this.setBounds(deskx, desky, panelHeight, panelWidth);  
      
    }
    
    
    public void paintComponent(Graphics g){
        move();
        g.setColor(Color.CYAN);
        g.draw3DRect(this.x, this.y, this.width, this.height, true);
        g.fill3DRect(x, y, width, height, true);
    }
    
    public double getCurrentX() {
        return super.getX();
    }
    
    public double getCurrrentY() {
        return super.getY();
    }
    
  
    public void move() {
        
        
    }
    
}


class Trashcan extends Rectangle{
    private int dy;
    private final Dimension size;
    private Image trashcanImage;
    private String deskID;
    
    
    public Trashcan(int panelHeight, int panelWidth,int deskx,int desky, String Name) {
        
        
        this.deskID = Name;
        this.size = new Dimension(panelWidth, panelHeight);
        this.setBounds(deskx, desky, panelHeight, panelWidth);  
      
    }
    
    
    public void paintComponent(Graphics g){
        move();
        g.setColor(Color.MAGENTA);
        g.draw3DRect(this.x, this.y, this.width, this.height, true);
        g.fill3DRect(x, y, width, height, true);
    }
    
    public double getCurrentX() {
        return super.getX();
    }
    
    public double getCurrrentY() {
        return super.getY();
    }
    
  
    public void move() {
        
        
    }
    
}

class Player1 extends Rectangle{
    private int dx;
    private int dy;
    private final Dimension size;
    private Image playerImage;
    private final int playerSize;
    private final int playerSpeed;
    
   
    public Player1(int panelWidth, int panelHeight){
        
        this.size = new Dimension(panelWidth, panelHeight);
        this.playerSize = 25;
        this.playerSpeed = 10;
        this.setBounds(0, 50, playerSize, playerSize);        
        
    }

    public void move() {
        this.x += dx;
        this.y += dy;
    }
    
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            this.dx = -20;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            this.dx = 20;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            this.dy = -20;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            this.dy = 20;
        }
    }
    
    public void keyReleased(KeyEvent e){
        this.dx = 0;
        this.dy = 0;
    }
    
    public void paintComponenet(Graphics g){
        
        move();
        g.setColor(Color.BLUE);
        g.drawRect(x, y, width, height);
    }
    
    public double getX(){
        return this.x;
    }
    
    public void setDx(int dx){
        this.x+=dx;
    }
    
    public double getY(){
        return this.x;
    }
    
    public void setDy(int dy){
        this.x+=dx;
    }
    
    
    
}

/**
 *
 * @author Graham
 */
class GameFrame1 extends JFrame{
    
    public GameFrame1(Hallway theRoom){
        this.setSize(new Dimension(500, 500));
        this.add(theRoom);
        this.validate();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}

