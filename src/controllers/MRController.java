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
import models.Customer;
import models.MeetingRoomMovement;
import views.MeetingRoomPanel;
import views.TestFrame;

/**
 *
 * @author Jon
 */
public class MRController {
    private MeetingRoomPanel mrp;
    private Timer gameTimer;
    public MRController() throws Exception
    {
        
        TestFrame testFrame = new TestFrame();
        Customer student = new Customer(new Dimension(800, 600));
        MeetingRoomMovement charMovement = new MeetingRoomMovement(student);
        mrp = new MeetingRoomPanel(student, charMovement);
        charMovement.setStations(mrp.getTable(), mrp.getProjector());
        testFrame.add(mrp);
        
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
            
            mrp.repaint();
                
            }
        }
}
