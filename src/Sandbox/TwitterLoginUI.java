/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import twitter4j.*;

/**
 *
 * @author laurenritter
 */
public class TwitterLoginUI extends JFrame implements ActionListener{
    private JButton loginButton;
    private JTextField usernameField;
    private JLabel username;
    private JLabel password;
    private JTextField passwordField;
    private JPanel panel;
    private Twitter twitter;
    private JLabel label;
    
    TwitterLoginUI(){
        initCustomComponents();
    }
    
    public void initCustomComponents(){
        panel = new JPanel();
        label = new JLabel("Please sign into your Twitter account.");
        loginButton = new JButton("Login");
        username = new JLabel("Username");
        password = new JLabel("Password");
        usernameField = new JTextField("");
        passwordField = new JTextField("");
        
        loginButton.addActionListener(this);
        usernameField.addActionListener(this);
        passwordField.addActionListener(this);
        
        panel.add(loginButton, SwingConstants.BOTTOM);
        panel.add(label, SwingConstants.TOP);
        panel.add(username);
        panel.add(usernameField);
        panel.add(password);
        panel.add(passwordField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loginButtonActionPerformed(e);
    }
    
    public void loginButtonActionPerformed(ActionEvent e){
//        try{
//        Twitter twitter = new TwitterFactory().getInstance();
//        User user = twitter.verifyCredentials();
//        JOptionPane.showMessageDialog(null, "showing @"+user.getScreenName()+ " You're logged in");
//        java.util.List<Status> statusList = twitter.getUserTimeline();
//        String timelineString = String.valueOf(statusList.get(0).getText());
//        jTextField1.setText(timelineString);
//        } catch (TwitterException e){
//            JOptionPane.showMessageDialog(null, "Login Failed");
//        }
    }
}
