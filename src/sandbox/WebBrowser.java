/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 *
 * @author lap5486
 */
public class WebBrowser {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
 {
     ImageIcon twitterImage;
    ImageIcon facebookImage;
    ImageIcon googleImage;
    JButton twitterButton;
    JButton facebookButton;
    JButton googleButton;
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    
    
    
        
     facebookButton = new JButton();
     facebookButton.addActionListener(new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent f)
            {
                String downloadURL="http://www.facebook.com/ISTatPENNSTATE";
    java.awt.Desktop openBrowser = java.awt.Desktop.getDesktop();
 try
  {
       java.net.URI myNewLocation = new java.net.URI(downloadURL);
      openBrowser.browse(myNewLocation);
  }
 catch(Exception e)
  {
   }
 // I used http://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java as a reference when creating the browser opener
            }
        });
     twitterButton = new JButton();
     twitterButton.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent f)
            {
                String downloadURL="http://www.twitter.com/ISTatPENNSTATE";
    java.awt.Desktop openBrowser = java.awt.Desktop.getDesktop();
 try
  {
       java.net.URI myNewLocation = new java.net.URI(downloadURL);
      openBrowser.browse(myNewLocation);
  }
 catch(Exception e)
  {
   }
            }
        });
     googleButton = new JButton();
     googleButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent f)
      {
        String downloadURL="https://www.google.com/search?q=puppies&hl=en&biw=1477&bih=931&site=webhp&source=lnms&tbm=isch&sa=X&ved=0ahUKEwidqM__xK_MAhXMWx4KHXaiDl8Q_AUIBigB";
    java.awt.Desktop openBrowser = java.awt.Desktop.getDesktop();
 try
  {
       java.net.URI myNewLocation = new java.net.URI(downloadURL);
      openBrowser.browse(myNewLocation);
  }
 catch(Exception e)
  {
   }
      }
    });
     twitterImage = new ImageIcon("src/sandbox/Weather Images/twitter.png");
        googleImage = new ImageIcon("src/sandbox/Weather Images/google.png");
        facebookImage = new ImageIcon("src/sandbox/Weather Images/facebook.png");
        twitterButton.setIcon(twitterImage);
        facebookButton.setIcon(facebookImage);
        googleButton.setIcon(googleImage);
        twitterButton.setSize(100,100);
        googleButton.setSize(100,100);
        facebookButton.setSize(100,100);
     
     f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(423,145);
        f.setResizable(false);
        f.add(p);
        p.add(twitterButton);
        p.add(facebookButton);
        p.add(googleButton);
     
     
     
     
     
  }}