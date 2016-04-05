/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author laurenritter
 */
public class TweetUI extends JFrame implements ActionListener{
    private JPanel tweetPanel;
    private JLabel enterTweet;
    private JTextField tweet;
    private JButton enterButton;
    
    TweetUI(){
        initCustomComponents();
    }
    
    public void initCustomComponents(){
        tweetPanel = new JPanel();
        enterTweet = new JLabel("Enter your tweet");
        tweet = new JTextField("");
        enterButton = new JButton("Enter");
        
        enterButton.addActionListener(this);
        tweet.addActionListener(this);
        
        tweetPanel.add(enterTweet);
        tweetPanel.add(tweet);
        tweetPanel.add(enterButton, SwingConstants.SOUTH_WEST);
        
        tweetPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
