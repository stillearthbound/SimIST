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
public class ShareToTwitter extends JFrame implements ActionListener{
    private JButton shareButton;
    private JTextField writeTweet;
    private JLabel title;
    private JPanel sharePanel;
    
    ShareToTwitter(){
        initCustomComponents();
    }
    
    public void initCustomComponents(){
        shareButton = new JButton("Share");
        writeTweet = new JTextField();
        title = new JLabel("Write Post");
        sharePanel = new JPanel();
        
        shareButton.addActionListener(this);
        
        sharePanel.add(title);
        sharePanel.add(writeTweet);
        sharePanel.add(shareButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shareButtonActionPerformed(e);
    }
    
    public void shareButtonActionPerformed(ActionEvent e){
        KeyReader keyreader = new KeyReader();
        
        ConfigurationBuilder cBuilder = new ConfigurationBuilder();
        cBuilder.setOAuthConsumerKey(keyreader.getConsumerKey());
        cBuilder.setOAuthConsumerSecret(keyreader.getConsumerSecret());
        cBuilder.setOAuthAccessToken(keyreader.getAccessToken());
        cBuilder.setOAuthAccessTokenSecret(keyreader.getAccessTokenSecret());
        
        TwitterFactory tFactory = new TwitterFactory(cBuilder.build());
        
    }
}
