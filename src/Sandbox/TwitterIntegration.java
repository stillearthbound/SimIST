/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author laurenritter
 */
public class TwitterIntegration {
    //private String username;
    //private String password;
    private String consumerKey = "jbe5ocgcxYSM49yvDM0KwywbC";
    private String consumerSecret = "GtuapOcOfLOvkqiyyBnArC0Vhv4iuoApKFGMUbqpyljlUs0NQO";
    private String accessToken = "717072723835490306-Iw6CNqn19C1vJzK7VPJdDxxdX7mga1h";
    private String accessTokenSecret = "32ifjEtUa6qeZnplyjjUvriGHCxNNsQdZpdN2hBNFeWQy";
    
    
    public TwitterIntegration(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
    }
}
