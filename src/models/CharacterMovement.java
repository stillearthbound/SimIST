package models;

/**
 *
 * @author Paul
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import views.Inventory;
import java.awt.event.KeyListener;
import views.GameRoom;
import sandbox.Weather;

public class CharacterMovement implements KeyListener {

    private Customer mStudent;
    private GameRoom mPanel;
    private Inventory mInventory;
    private String facing = "";
    private boolean isInteracting = false;
    private int frame = 0;
    private int stationNumber;

    public CharacterMovement(Customer student, GameRoom panel, Inventory inventory) {

        mStudent = student;
        mPanel = panel;
        mInventory = inventory;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        double tempLeftRight = mPanel.getWidth() * .00625;
        double tempUpDown = mPanel.getHeight() * .00833333;

        int oldX = mStudent.x;
        int oldY = mStudent.y;

        if (!mStudent.getAnimation().equals(facing)) {
            isInteracting = false;

        }


        switch (ke.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (frame < 5) {
                    mStudent.setAnimation(mStudent.getAnimations()[0]);
                    frame += 1;
                } else if (frame >= 5 && frame < 10) {
                    mStudent.setAnimation(mStudent.getAnimations()[1]);
                    frame += 1;
                } else if (frame > 9) {
                    frame = 0;
                }
                mStudent.x = mStudent.x + (int) tempLeftRight;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (frame < 5) {
                    mStudent.setAnimation(mStudent.getAnimations()[2]);
                    frame += 1;
                } else if (frame >= 5 && frame < 10) {
                    mStudent.setAnimation(mStudent.getAnimations()[3]);
                    frame += 1;
                } else if (frame > 9) {
                    frame = 0;
                }
                mStudent.x = mStudent.x - (int) tempLeftRight;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (frame < 5) {
                    mStudent.setAnimation(mStudent.getAnimations()[4]);
                    frame += 1;
                } else if (frame >= 5 && frame < 10) {
                    mStudent.setAnimation(mStudent.getAnimations()[5]);
                    frame += 1;
                } else if (frame > 9) {
                    frame = 0;
                }
                mStudent.y = mStudent.y - (int) tempUpDown;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (frame < 5) {
                    mStudent.setAnimation(mStudent.getAnimations()[6]);
                    frame += 1;
                } else if (frame >= 5 && frame < 10) {
                    mStudent.setAnimation(mStudent.getAnimations()[7]);
                    frame += 1;
                } else if (frame > 9) {
                    frame = 0;
                }
                mStudent.y = mStudent.y + (int) tempUpDown;
                break;
            case KeyEvent.VK_M:
                //System.out.println("M pressed");
                try{
                    Weather.main(new String[]{"arg1", "arg2", "arg3"});
            
                }
                catch (Exception e) {
                
                }
                break;
            default:
                break;
        }

        /*

             PRESSING 'I' POPS UP INVENTORY

         */
        if (ke.getKeyCode() == KeyEvent.VK_I) { 
            mInventory.popUpInventory(mStudent.getInventory());
            mInventory.setLocationRelativeTo(mPanel);
        }
        

        for (Rectangle station : mPanel.getStations()) {
            if (mStudent.intersects(station)) {
                mStudent.x = oldX;
                mStudent.y = oldY;

                isInteracting = true;
                facing = mStudent.getAnimation();
                stationNumber = mPanel.getStations().indexOf(station);

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }



    public String getFacing() {
        return facing;
    }

    public void setFacing(String set) {
        facing = set;
    }

    public boolean getIsInteracting() {
        return isInteracting;
    }

    public void setIsInteracting(boolean set) {
        isInteracting = set;
    }


    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int set) {
        stationNumber = set;
    }

}
