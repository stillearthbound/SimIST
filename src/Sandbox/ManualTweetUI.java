/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author laurenritter
 */
public class ManualTweetUI extends JFrame implements ActionListener{
    private JButton postButton;
    private JButton backButton;
    private JPanel panel;
    private JLabel postLabel;
    private JTextField tweetText;
    private TwitterCntl theTwitterCntl;
    private JFrame frame;
    
    public ManualTweetUI(){
        super();
        
        frame = new JFrame();
        frame.setSize(250, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        initCustomComponents();
    }
    
    public void initCustomComponents(){
        postButton = new JButton("Post");
        backButton = new JButton("Back");
        panel = new JPanel();
        postLabel = new JLabel("Post to Twitter");
        tweetText = new JTextField();
        
        postButton.addActionListener(this);
        backButton.addActionListener(this);
        
        tweetText.setSelectedTextColor(Color.CYAN);
        
        panel.add(postLabel);
        panel.add(tweetText);
        panel.add(postButton);
        panel.add(backButton);
        
        frame.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        postButtonActionPerformed(e);
        backButtonActionPerformed(e);
    }
    
    public void postButtonActionPerformed(ActionEvent e){
        //connects to the KeyReader class that has all of the account's credentials
        KeyReader keyreader = new KeyReader();
        
        //logs into the 311 twitter account
        ConfigurationBuilder cBuilder = new ConfigurationBuilder();
        cBuilder.setOAuthConsumerKey(keyreader.getConsumerKey());
        cBuilder.setOAuthConsumerSecret(keyreader.getConsumerSecret());
        cBuilder.setOAuthAccessToken(keyreader.getAccessToken());
        cBuilder.setOAuthAccessTokenSecret(keyreader.getAccessTokenSecret());
        
        Twitter tFactory = new TwitterFactory(cBuilder.build()).getInstance();
        
        try{
            tFactory.updateStatus(tweetText.getText());
        }catch(TwitterException te){
            te.printStackTrace();
        }
    }
    
    public void backButtonActionPerformed(ActionEvent e){
        theTwitterCntl = new TwitterCntl();
        theTwitterCntl.switchhToTwitterUI();
    }
}
