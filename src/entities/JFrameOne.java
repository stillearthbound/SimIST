/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sns5408
 */
    public class JFrameOne extends JFrame {
         public ImageIcon image1;
         public final int ImageSize;
         public Image Aimage;
          
      public JFrameOne() 
          {
              super();
        JFrame f = new JFrame("Test");
        
        JLabel lblDisplay = new JLabel(new ImageIcon("src/entities/table.jpg"));
        JPanel pan1 = new JPanel(new BorderLayout(450,450));
        pan1.add(lblDisplay, BorderLayout.CENTER);
        getContentPane().add(pan1, BorderLayout.CENTER);

        
        image1= new ImageIcon("src/entities/table.jpg");
        ImageSize = image1.getIconWidth();
        Aimage = image1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        setBounds(400, 400, ImageSize, ImageSize);
     
       
      
        
        /*f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1200,700);
        f.setResizable(false); 
        f.add(w);
        f.setVisible(true);
        */
          }
      
       
    public class JPanelOne extends JPanel implements ActionListener {
       Timer t = new Timer(5,this);
        
       Furniture furn1 = new Furniture("Table",true, true,50, 50, Aimage);
     
       private JTextArea b;
        
       JPanelOne(){
       //Test
            b= new JTextArea("Test");
            b.setEditable(false);
            add(b);
            furn1.getArtifactInfo();
        } 
       
        public void actionPerformed(ActionEvent e){   
           t.start();
        }
       
        public void paintComponent(Graphics g){
            
            super.paintComponent(g);
            
        g.drawImage(Aimage, 0, 0, null);
           
           
        }
       
    }
    
}
