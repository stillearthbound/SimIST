/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author greg
 */
public class TestFrame extends JFrame {

    public TestFrame()
    {
        super();
        setSize(800,600);
        setResizable(false);
        setVisible(true);
        validate();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(false);
    }
}
