/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Suzanne
 */
public class Furniture extends Artifacts{
        
        
        Furniture(String ArtifactName,boolean isUsable, boolean isCollidable, int xLocation, int yLocation,Image artifacts ){
            
            super(ArtifactName,isUsable,isCollidable,xLocation,yLocation,artifacts);
         
        
         
         
        
         
        }
            public void Draw(Graphics g){
               super.Draw(g);
            }
            public void getArtifactInfo(){
                super.getArtifactInfo();
            }
            
    
}
