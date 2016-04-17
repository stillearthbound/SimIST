/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sounds;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 *
 * @author Qiu
 */
public class Model {
    
    public void buttonSound(){
      //Reference: http://stackoverflow.com/questions/10570537/java-no-sound-played-for-button
      try{
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream (new File("src\\music\\button.wav"));
          //R: http://opengameart.org/content/forward-button-press-ui-sound
          Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
        }
    }
    
        public void playBGM(){
      //Reference: http://stackoverflow.com/questions/10570537/java-no-sound-played-for-button
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream (new File("src\\music\\op.wav"));
            //R: http://opengameart.org/content/introduction-gm-version
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        }
        catch(Exception e)
        {
            System.out.println("Error with playing");
        }
    }
    
        //http://opengameart.org/content/sound-effects-sfx028
        public void playLeftKey(){
          try{
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream (new File("src\\music\\arrow.wav"));
          Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
        } 
        }
        public void playRightKey(){
          try{
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream (new File("src\\music\\arrow.wav"));
          Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
        } 
        }
        
        public void playUpKey(){
          try{
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream (new File("src\\music\\arrow.wav"));
          Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
        } 
        }
        public void playDownKey(){
          try{
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream (new File("src\\music\\arrow.wav"));
          Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
        } 
        }
}
