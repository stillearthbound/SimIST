
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import views.*;
import models.*;
import javax.swing.Timer;
/**
 *
 * @author Paul
 */
public class ABPController {
   
    private AuBonPainPanel abp;
    private Timer gameTimer;
    public ABPController() throws Exception
    {
        
        TestFrame testFrame = new TestFrame();
        Customer student = new Customer();
        CharacterMovement charMovement = new CharacterMovement(student);
        abp = new AuBonPainPanel(student, charMovement);
        charMovement.setStations(abp.getCounter(), abp.getCoffee(), abp.getSign(), abp.getTrash(), abp.getBakery(), abp.getFruit(), abp.getSoup(), abp.getCooler());
        testFrame.add(abp);
        
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
            
            abp.repaint();
                
            }
        }
    
}
