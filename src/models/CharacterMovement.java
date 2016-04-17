package models;

/**
 *
 * @author Paul
 */
import java.awt.*;
public class CharacterMovement  {

    private String animation = "left1.png";
    private String facing = "";
<<<<<<< Updated upstream
=======
    private int stationFound;
    private ArrayList<Rectangle> stations = new ArrayList<>();
    private ArrayList<Rectangle> room206items = new ArrayList<>();
>>>>>>> Stashed changes
    private boolean isInteracting = false;
    private int frame = 0;
    private int stationNumber;


    public CharacterMovement() {
     

    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String set) {
        animation = set;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String set) {
        facing = set;
    }
    
<<<<<<< Updated upstream
    public boolean getIsInteracting()
    {
        return isInteracting;
=======
    private void intersects() {

        for (Rectangle station : stations) {
            if (student.intersects(station)) {
                isInteracting = true;
                facing = animation;
                student.x = oldX;
                student.y = oldY;
                stationFound = stations.indexOf(station);
            }
        }
        for (Rectangle room206Items: room206items){
            if(student.intersects(room206Items)){
                isInteracting = true;
                facing = animation;
                student.x = oldX;
                student.y = oldY;
               // itemfound = room206items.indexOf(room206items);
                
            }
        }
>>>>>>> Stashed changes
    }
    
    public void setIsInteracting(boolean set)
    {
        isInteracting = set;
    }
    
    public int getFrame()
    {
        return frame;
    }
    
    public void setFrame(int set)
    {
        frame = set;
    }
<<<<<<< Updated upstream
=======
    
    public void setRoom206(Rectangle shelf1,Rectangle shelf2, Rectangle longtable, Rectangle middletable1, Rectangle middletable2, Rectangle middletable3, Rectangle middletable4, Rectangle middletable5, Rectangle middletable6, Rectangle shorttable, Rectangle cornertable1, Rectangle cornertable2, Rectangle cornertable3){
        room206items.add(shelf1);
        room206items.add(shelf2);
        room206items.add(longtable);
        room206items.add(middletable1);
        room206items.add(middletable2);
        room206items.add(middletable3);
        room206items.add(middletable4);
        room206items.add(middletable5);
        room206items.add(middletable6);
        room206items.add(shorttable);
        room206items.add(cornertable1);
        room206items.add(cornertable2);
        room206items.add(cornertable3);
  
    }
    public void setWall(Rectangle wallUD1, Rectangle wallUD2, Rectangle wallLR1, Rectangle wallLR2)
    {
        room206items.add(wallUD1);
        room206items.add(wallUD2);
        room206items.add(wallLR1);
        room206items.add(wallLR2); 
    }
>>>>>>> Stashed changes
    
    public int getStationNumber()
    {
        return stationNumber;
    }
    
    public void setStationNumber(int set)
    {
        stationNumber = set;
    }

}
