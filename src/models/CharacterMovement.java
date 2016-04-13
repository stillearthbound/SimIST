package models;

/**
 *
 * @author Paul
 */

public class CharacterMovement  {

    private String animation = "left1.png";
    private String facing = "";
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
    
    public boolean getIsInteracting()
    {
        return isInteracting;
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
    
    public int getStationNumber()
    {
        return stationNumber;
    }
    
    public void setStationNumber(int set)
    {
        stationNumber = set;
    }

}
