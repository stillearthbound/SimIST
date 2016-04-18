package models;

/**
 *
 * @author Paul
 */
import entities.Room;
import java.awt.*;
import java.awt.event.KeyEvent;
import views.Inventory;
import views.MenuPanel;
import views.TestFrame;
import java.awt.event.KeyListener;
import views.GameRoom;

public class CharacterMovement implements KeyListener {

    private TestFrame mTestFrame;
    private MenuPanel mMenuPanel;
    private Customer mStudent;
    private Inventory mInventory;
    private GameRoom mPanel;
    private String animation = "left1.png";
    private String facing = "";
    private boolean isInteracting = false;
    private int frame = 0;
    private int stationNumber;

    public CharacterMovement(TestFrame testFrame, MenuPanel menuPanel, Customer student, Inventory inventory, GameRoom panel) {
        mTestFrame = testFrame;
        mMenuPanel = menuPanel;
        mStudent = student;
        mInventory = inventory;
        mPanel = panel;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        double tempLeftRight = mPanel.getWidth() * .00625;
        double tempUpDown = mPanel.getHeight() * .00833333;

        if (mMenuPanel != null) {
            mMenuPanel.dispose();
        }
        if (mInventory != null) {
            mInventory.dispose();
        }
        int oldX = mStudent.x;
        int oldY = mStudent.y;

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
                }   mStudent.x = mStudent.x + (int) tempLeftRight;
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
                }   mStudent.x = mStudent.x - (int) tempLeftRight;
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
                }   mStudent.y = mStudent.y - (int) tempUpDown;
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
                }   mStudent.y = mStudent.y + (int) tempUpDown;
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

        if (!animation.equals(facing)) {
            isInteracting = false;
            
        }

        for (Rectangle station : mPanel.getStations()) {
            if (mStudent.intersects(station)) {
                mStudent.x = oldX;
                mStudent.y = oldY;

                isInteracting = true;
                facing = animation;
                stationNumber = mPanel.getStations().indexOf(station);

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

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

    public boolean getIsInteracting() {
        return isInteracting;
    }

    public void setIsInteracting(boolean set) {
        isInteracting = set;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int set) {
        frame = set;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int set) {
        stationNumber = set;
    }

}
