/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

import javax.swing.JPanel;

/**
 *
 * @author laurenritter
 */
public class TwitterCntl {
    private WriteTweet theWriteTweet;
    private TwitterUI theTwitterUI;
    
    public TwitterCntl(){
//        theWriteTweet = new WriteTweet();
//        theWriteTweet.setVisible(true);
    }
    
    public void switchhToTwitterUI(){
        theTwitterUI = new TwitterUI();
        theTwitterUI.setVisible(true);
    }
    
    public void switchToWriteTweet(){
        theWriteTweet = new WriteTweet();
        theWriteTweet.setVisible(true);
    }
}
