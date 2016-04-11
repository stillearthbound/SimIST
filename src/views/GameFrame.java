/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Dimension;
import  javax.swing.*;

/**
 *
 * @author matthewtucker
 */
public class GameFrame extends JFrame {
    
    

    public GameFrame(String title) {
        
    
        this.setTitle(title);
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    
}
}