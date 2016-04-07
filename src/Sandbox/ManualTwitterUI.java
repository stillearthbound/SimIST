/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author laurenritter
 */
public class ManualTwitterUI extends JFrame implements ActionListener{
    private JPanel tweetPanel;
    private JLabel enterTweet;
    private JTextArea timelineTweetText;
    private JButton enterButton;
    private TwitterCntl theTwitterCntl;
    private JFrame frame;
    private JScrollPane scrollpane;
    
    public ManualTwitterUI(TwitterCntl parentTwitterCntl){
        super();
        theTwitterCntl = parentTwitterCntl;
        
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setSize(250, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initCustomComponents();
    }
    
    public void initCustomComponents(){
        frame.setLocationRelativeTo(this);
        
        tweetPanel = new JPanel();
        enterTweet = new JLabel("Get Timeline");
        timelineTweetText = new JTextArea();
        enterButton = new JButton("Enter");
        scrollpane = new JScrollPane();
        
        enterButton.addActionListener(this);
        timelineTweetText.setColumns(20);
        timelineTweetText.setRows(10);
        scrollpane.setViewportView(timelineTweetText);
        
        tweetPanel.add(enterTweet);
        tweetPanel.add(scrollpane);
        tweetPanel.add(enterButton);
        tweetPanel.setVisible(true);
        
        tweetPanel.setSize(250, 300);
        frame.add(tweetPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enterButtonActionPerformed(e);
    }
    
    public void enterButtonActionPerformed(ActionEvent e){
        KeyReader keys = new KeyReader();
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(keys.getConsumerKey())
                .setOAuthConsumerSecret(keys.getConsumerSecret())
                .setOAuthAccessToken(keys.getAccessToken())
                .setOAuthAccessTokenSecret(keys.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try{
            System.out.println("timeline retreval worked");
        
        
        List<Status> statuses = twitter.getHomeTimeline();
        for(Status status : statuses){
            timelineTweetText.append("@"+status.getUser().getName()+" : "+status.getText()+"\n"+"\n");
            timelineTweetText.setLineWrap(true);
            timelineTweetText.setWrapStyleWord(true);
            System.out.println("@"+status.getUser().getName()+" : "+status.getText());
        }
        
        
        }catch (TwitterException te){
            System.out.print("timeline retreval failed");
        }
    }
}
