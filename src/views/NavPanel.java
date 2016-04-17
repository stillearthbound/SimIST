/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Laura
 */
public class NavPanel extends JFrame{
    JFrame frame=new JFrame("SimIST");
    
    JPanel nav=new JPanel();
    JButton startButton= new JButton("Start SimIST");
    JButton instructionPanelButton= new JButton("Instructions");
    JButton highScorePanelButton= new JButton("HighScores");
    JTextField title = new JTextField("SimIST");
    
    Font font = new Font("Courier", Font.BOLD,30);
    ImageIcon startButtonImage;
    Dimension d = new Dimension(100,100);
//    GamePanel g= new GamePanel();
    JPanel gamePanel = new JPanel();
//    InstructionPanel i= new InstructionPanel();
    JPanel instructionPanel = new JPanel();
//    HighscorePanel h = new HighscorePanel();
    JPanel highscorePanel = new JPanel();
    
    public NavPanel(){
        
        //creating the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        
        //startButtonImage = new ImageIcon("res/IST.jpg");
        
        //startButton = new JButton(startButtonImage);
        startButton.setPreferredSize(d);
        
        //adding things to the nav panel
        this.add(nav);
        nav.setLayout(new BorderLayout());
        title.setFont(font);
        title.setHorizontalAlignment(JTextField.CENTER);
        nav.add(title, BorderLayout.NORTH);
        title.setEditable(false);
        
        //adding action listeners
        nav.add(startButton, BorderLayout.CENTER);
        startButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) { startButtonActionPerformed(evt); }});
        
        nav.add(instructionPanelButton, BorderLayout.WEST);
        instructionPanelButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) { instructionPanelButtonActionPerformed(evt); }});
        
        nav.add(highScorePanelButton, BorderLayout.EAST);
        highScorePanelButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) { highScorePanelButtonActionPerformed(evt); }});
        
        frame.setVisible(true);
        frame.add(nav);
    }
    
    //action listener methods
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        nav.setVisible(false);
        frame.add(gamePanel);
    }
    
    private void instructionPanelButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        nav.setVisible(false);
        frame.add(instructionPanel);
    }
    
    private void highScorePanelButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        nav.setVisible(false);
        frame.add(highscorePanel);
    }
    
   // public void paintComponent(Graphics g){
    //    g.drawImage(startButtonImage.getImage(), 0,0, startButton);
    //}
}
