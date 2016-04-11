/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author aot5238 and lmo5113
 *
 */
public class Options extends JFrame
{     
     private boolean pauseOption = false; 
     private JButton start; 
     private JButton pause; 
     static final int volMin = 0;
     static final int volMax = 100;
     static final int volInit = 50;
     JFrame frame = new JFrame("Options");
     
    public Options()
    {
        super();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setBackground(Color.GREEN);
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addComponents(){
        JSlider volume = new JSlider(JSlider.HORIZONTAL, volMin, volMax, volInit);
        
        volume.addChangeListener(null);
        volume.setMajorTickSpacing(10);
        volume.setMinorTickSpacing(2);
        volume.setPaintTicks(true);
        volume.setPaintLabels(true);
        
        Font volFont = new Font("Serif", Font.BOLD, 15);
        volume.setFont(volFont);
        
        start = new JButton("Start");
        pause = new JButton("Pause");
        
        add(start);
        add(pause);
    }
    
    public void stateChanged(ChangeEvent e)
    {
        JSlider source = (JSlider)e.getSource();
        if(!source.getValueIsAdjusting()){
            int volume = (int)source.getValue();
            if(volume == 0){
                
            }
        }
    }
    
    public void setStart(JButton start) {
        this.start = start;
    }
    
     public JButton getStart() {
        return start;
    }
    
      public void setPauseOption(JButton pause) {
        this.pauseOption = pauseOption; 
    }
      
       public boolean getPauseOption() {
        return pauseOption;
    }

    public void setSize(int i, int panelHeight) {
        //throw new UnsupportedOperationException(); 
    }
  
    public void setPreferredSize(Dimension dimension) {
        //throw new UnsupportedOperationException(" "); 
    }

    public void setBackground(Color GREEN) {
        //throw new UnsupportedOperationException(""); 
    }

    private void setLayout(GridBagLayout gridBagLayout) {
        //throw new UnsupportedOperationException(); 
                }

}
