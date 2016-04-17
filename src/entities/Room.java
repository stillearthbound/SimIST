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
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author evangentis
 */
public class Room extends JPanel implements ActionListener, KeyListener{
    private int roomNumber;
    private Timer timer1;
    private String currentClass;
    private ArrayList<Desk>  desks;
    private ArrayList<Object> computers;
    private Image roomImage;
    private Player player1;
    //private GameFrame theFrame;
    
    public Room(int theRoomNumber){
       super();
       this.addKeyListener(this);
       this.player1 = new Player(500, 500);
       
       //this.theFrame = new GameFrame(this);
       this.setFocusable(true);
       this.roomNumber =  theRoomNumber;
       this.currentClass = "";
       this.desks = new ArrayList<Desk>();
       populateDesks();
       this.timer1 = new Timer(50, this);
       this.timer1.start();
       this.computers = new ArrayList<Object>();
       
    }

    public final void populateDesks(){
        
            
            Desk newDesk = new Desk(50, 50,100, 50, "Desk1");
            Desk newDesk2 = new Desk(50, 50,100, 120, "Desk2");
            Desk newDesk3 = new Desk(50, 50,100, 190, "Desk3");
            Desk newDesk4 = new Desk(50, 50,100, 260, "Desk4");
            Desk newDesk5 = new Desk(50, 50,100, 330, "Desk5");
            Desk newDesk6 = new Desk(50, 50,100, 400, "Desk6");
            Desk newDesk7 = new Desk(50, 50,100, 5470, "Desk7");
            Desk newRowDesk = new Desk(50, 50,300, 50, "Desk1");
            Desk newRowDesk2 = new Desk(50, 50,300, 120, "Desk2");
            Desk newRowDesk3 = new Desk(50, 50,300, 190, "Desk3");
            Desk newRowDesk4 = new Desk(50, 50,300, 260, "Desk4");
            Desk newRowDesk5 = new Desk(50, 50,300, 330, "Desk5");
            Desk newRowDesk6 = new Desk(50, 50,300, 400, "Desk6");
            Desk newRowDesk7 = new Desk(50, 50,300, 5470, "Desk7");
            desks.add(newDesk);
            desks.add(newDesk2);  
            desks.add(newDesk3);  
            desks.add(newDesk4);  
            desks.add(newDesk5);
            desks.add(newDesk6);  
            desks.add(newDesk7);
            desks.add(newRowDesk);
            desks.add(newRowDesk2);  
            desks.add(newRowDesk3);  
            desks.add(newRowDesk4);  
            desks.add(newRowDesk5);
            desks.add(newRowDesk6);  
            desks.add(newRowDesk7);
            
            
        
    }
    
    /**
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return the currentClass
     */
    public String getCurrentClass() {
        return currentClass;
    }

    /**
     * @param currentClass the currentClass to set
     */
    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    /**
     * @return the desks
     */
    public ArrayList<Desk> getDesks() {
        return desks;
    }

    /**
     * @param desks the desks to set
     */
    public void setDesks(ArrayList<Desk> desks) {
        this.desks = desks;
    }

    /**
     * @return the computers
     */
    public ArrayList<Object> getComputers() {
        return computers;
    }

    /**
     * @param computers the computers to set
     */
    public void setComputers(ArrayList<Object> computers) {
        this.computers = computers;
    }

    @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.clearRect(0, 0, this.getWidth(), this.getHeight());
       player1.paintComponenet(g);
       paintDesks(g);
          
        
    }
    
     public void paintDesks(Graphics g){
      for(int i = 0; i<desks.size(); i++)
       {
           desks.get(i).paintComponent(g);
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
    
    
}

class Desk extends Rectangle{
    private int dy;
    private final Dimension size;
    private Image obstacleImage;
    private final int obstacleSize;
    private final int obstacleSpeed;
    private String deskID;
    
    
    public Desk(int panelHeight, int panelWidth,int deskx,int desky, String Name) {
        
        
        this.deskID = Name;
        this.size = new Dimension(panelWidth, panelHeight);
        this.obstacleSize = 50;
        this.obstacleSpeed = 7;
        double r = Math.random();
        int random = (int)(r * panelWidth-50);
        this.setBounds(deskx, desky, obstacleSize, obstacleSize);  
      
    }
    
    
    public void paintComponent(Graphics g){
        move();
        g.setColor(Color.RED);
        g.drawRect(this.x, this.y, this.width, this.height);
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

class Player extends Rectangle{
    private int dx;
    private int dy;
    private final Dimension size;
    private Image skydiverImage;
    private final int skydiverSize;
    private final int skydiverSpeed;
    
   
    public Player(int panelWidth, int panelHeight){
        
        this.size = new Dimension(panelWidth, panelHeight);
        this.skydiverSize = 50;
        this.skydiverSpeed = 10;
        this.setBounds(0, 50, skydiverSize, skydiverSize);        
        
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
//class GameFrame extends JFrame{
//    
//    public GameFrame(Room theRoom){
//        this.setSize(new Dimension(500, 500));
//        //this.add(theRoom);
//        this.validate();
//        this.setVisible(true);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//    }
//}
