/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.swing.Timer;
import models.CharacterInventory;
import models.CharacterMovement;
import models.Customer;
import views.Inventory;
import views.MenuPanel;
import views.Room206;
import views.TestFrame;

/**
 *
 * @author qpm5006
 */
public class RoomController {
    private Timer gameTimer;
    private Room206 room;
    private MenuPanel menuPanel;
    private Inventory inventory;
    private Customer student;
    private CharacterInventory charInventory;
    private CharacterMovement charMovement;
    
    public RoomController() throws Exception
    {
        
        TestFrame testFrame = new TestFrame();
        testFrame.setSize(530,670);
        student = new Customer(new Dimension(800,600));
        room = new Room206(student);
        menuPanel = new MenuPanel();
        inventory = new Inventory();
        charInventory = new CharacterInventory();
        charMovement = new CharacterMovement(testFrame, menuPanel, student, inventory, room, charInventory);
        
        testFrame.add(room);
        
        room.requestFocusInWindow();
        room.addKeyListener(charMovement);
        
        
        
        gameTimer = new Timer(5,new GameTimer());
        gameTimer.start();
        InputStream is;
        Sequencer sequence;
        sequence = MidiSystem.getSequencer();
        sequence.open();
        is = new BufferedInputStream(new FileInputStream(new File("beatit.mid")));
        sequence.setSequence(is);
        sequence.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        sequence.start();
        is.close();

    }
    
    class GameTimer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
             room.repaint();
                
            }
        }
    
}
    

