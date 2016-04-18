package views;


import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aot5238
 */
public class Cybertorium extends JPanel
{
    JButton table1, table2, table3, table4, table5;
    
    public Cybertorium()
    {
        table1 = new JButton();
        table2 = new JButton();
        table3 = new JButton();
        table4 = new JButton();
        table5 = new JButton();
        
        add(table1);
        add(table2);
        add(table3);
        add(table4);
        add(table5);
        
        table1.setOpaque(false);
        table1.setContentAreaFilled(false);
        table1.setBorderPainted(false);
        table2.setOpaque(false);
        table2.setContentAreaFilled(false);
        table2.setBorderPainted(false);
        table3.setOpaque(false);
        table3.setContentAreaFilled(false);
        table3.setBorderPainted(false);
        table4.setOpaque(false);
        table4.setContentAreaFilled(false);
        table4.setBorderPainted(false);
        table5.setOpaque(false);
        table5.setContentAreaFilled(false);
        table5.setBorderPainted(false);
        
        table1.setBounds(new Rectangle (90, 92, 805, 10));
        table2.setBounds(new Rectangle (90, 182, 805, 5));
        table3.setBounds(new Rectangle (90, 255, 805, 5));
        table4.setBounds(new Rectangle (90, 335, 805, 5));
        table5.setBounds(new Rectangle (90, 410, 805, 15));
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ImageIcon Icon = new ImageIcon("cybertorium.jpg");
        g.drawImage(Icon.getImage(), 0, 0, this);
        
    }
}
