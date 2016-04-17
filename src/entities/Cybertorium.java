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
public class Cybertorium extends JPanel implements ActionListener, KeyListener{
    private ArrayList<Table> tables;
    private Player1 player1;
    private GameFrame2 theFrame;
    private Timer timer1;
    
    public Cybertorium(){
       super();
       this.addKeyListener(this);
       this.player1 = new Player1(500, 500);
       
       this.theFrame = new GameFrame2(this);
       this.setFocusable(true);
       this.tables = new ArrayList<Table>();
       populateTables();
       this.timer1 = new Timer(50, this);
       this.timer1.start();
       
    }
    
    private void  populateTables(){
        Table table1 = new Table(200, 30, 150, 30, "Table 1");
        Table table2 = new Table(410, 50, 45, 130, "Table 1");
        Table table3 = new Table(410, 50, 45, 210, "Table 1");
        Table table4 = new Table(410, 50, 45, 290, "Table 1");
        Table table5 = new Table(410, 50, 45, 370, "Table 1");
        Table table6 = new Table(30, 30, 45, 30, "Table 1");
        
        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        tables.add(table4);
        tables.add(table5);
        tables.add(table6);
        
    }
    @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.clearRect(0, 0, this.getWidth(), this.getHeight());
       player1.paintComponenet(g);
       paintDesks(g);
          
        
    }
    
     public void paintDesks(Graphics g){
      for(int i = 0; i<tables.size(); i++)
       {
           tables.get(i).paintComponent(g);
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
    public GameFrame2 getTheFrame() {
        return theFrame;
    }

    /**
     * @param theFrame the theFrame to set
     */
    public void setTheFrame(GameFrame2 theFrame) {
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


class GameFrame2 extends JFrame{
    
    public GameFrame2(Cybertorium theRoom){
        this.setSize(new Dimension(500, 500));
        this.add(theRoom);
        this.validate();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
