/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.*;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.*;

/**
 *
 * @author sns5408
 */
public class Artifacts extends Rectangle {
    
   public String ArtifactName;
   
   public boolean isUsable;
   public boolean isEditable; 
   public boolean isCollidable; 
   
   public int xLocation;
   public int yLocation; 
  
   public Image artifacts; 
   
   
  Artifacts(String ArtifactName,boolean isUsable, boolean isCollidable, int xLocation, int yLocation, Image artifacts)
   {
       this.ArtifactName=ArtifactName;
       this.isUsable=isUsable; 
       this.isEditable = isEditable;
       this.isCollidable=isCollidable;
       this.xLocation=xLocation;
       this.yLocation=yLocation; 
       this.artifacts = artifacts;
       
   }
   
    
    public void Draw(Graphics g){
        g.drawImage(artifacts, xLocation, yLocation, null);
        
        
        
        
    }
            
 public void getArtifactInfo(){
        System.out.println(ArtifactName +" "+ isUsable+" "+ isCollidable);
    }
    
   
   /* public void getLocation(){
        //return location
    }
*/
    /**
     * @return the ArtifactMaterial
     */
   
    }

 
   /* public class Furniture extends Artifacts{
        
        
        Furniture(String ArtifactName,boolean isUsable, boolean isCollidable, int xLocation, int yLocation,Image artifacts ){
            
            super(ArtifactName,isUsable,isCollidable,xLocation,yLocation,artifacts);
         
        
         
         
        
         
        }
            public void Draw(Graphics g){
               super.Draw(g);
            }
            public void getArtifactInfo(){
                super.getArtifactInfo();
            }
            public String getArtifactName(){
                return super.ArtifactName;
            }
            
        }
    */

 
      
    
    
    
    

