/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author greg
 */
public class TestFrame extends JFrame {
    

    
    public TestFrame()
    {
        super();
        setSize(800,600);
        setPreferredSize(new Dimension(800,600));
        //setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(false);
        
    }
}
