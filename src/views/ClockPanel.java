/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import sandbox.ClockControl;

/**
 *
 * @author Allison
 */
public class ClockPanel extends JPanel implements ActionListener{
    private ClockControl clock;
    private Timer updater;
    private JButton speedUpButton;
    private JButton slowDownButton;
    private JButton pauseButton;
    private JLabel timeDisplay;
    
    
    public ClockPanel() throws ParseException{
        this.clock = new ClockControl();
        
        speedUpButton = new JButton("speed up");
        slowDownButton = new JButton("slow down");
        pauseButton = new JButton("pause");
        timeDisplay = new JLabel(clock.display());
        
        speedUpButton.addActionListener(this);
        slowDownButton.addActionListener(this);
        pauseButton.addActionListener(this);
        
        //updater = new Timer(60000,new UpdateTimer());
        //updater.start();
        
        this.add(speedUpButton);
        this.add(slowDownButton);
        this.add(pauseButton);
        this.add(timeDisplay);
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if (o == speedUpButton)
            clock.speedup();
        if (o == slowDownButton)
            clock.slowdown();
        if (o == pauseButton)
            clock.pause();        
    }
    
    class UpdateTimer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            timeDisplay.setText(clock.display());
            timeDisplay.repaint();
        }
        
    }
    
}
