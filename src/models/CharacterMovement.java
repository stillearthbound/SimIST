package models;

/**
 *
 * @author Paul
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.*;

public class CharacterMovement implements KeyListener {

    private Customer student;
    private int frame = 0;
    private String animation = "left1.png";
    private String facing = "";
    private int stationFound;
    private ArrayList<Rectangle> stations = new ArrayList<>();
    private boolean isInteracting = false;
    private int oldX;
    private int oldY;


    public CharacterMovement(Customer inf_Student) {
        student = inf_Student;

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        oldX = student.x;
        oldY = student.y;

        if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D) {
            if (frame < 5) {
                animation = student.getAnimation()[0];
                frame++;
            } else if (frame >= 5 && frame < 10) {
                animation = student.getAnimation()[1];
                frame++;
            } else if (frame > 9) {
                frame = 0;
            }
            student.x = student.x + 5;
        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A) {

            if (frame < 5) {
                animation = student.getAnimation()[2];
                frame++;
            } else if (frame >= 5 && frame < 10) {
                animation = student.getAnimation()[3];
                frame++;
            } else if (frame > 9) {
                frame = 0;
            }
            student.x = student.x - 5;
        } else if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W) {
            if (frame < 5) {
                animation = student.getAnimation()[4];
                frame++;
            } else if (frame >= 5 && frame < 10) {
                animation = student.getAnimation()[5];
                frame++;
            } else if (frame > 9) {
                frame = 0;
            }
            student.y = student.y - 5;
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S) {
            if (frame < 5) {
                animation = student.getAnimation()[6];
                frame++;
            } else if (frame >= 5 && frame < 10) {
                animation = student.getAnimation()[7];
                frame++;
            } else if (frame > 9) {
                frame = 0;
            }
            student.y = student.y + 5;
        }

        if (!animation.equals(facing)) {
            isInteracting = false;
        }

        intersects();

        if (ke.getKeyCode() == KeyEvent.VK_SPACE && isInteracting) {

            switch (stationFound) {

                case 0:
                    System.out.println("counter initiated");
                    break;
                case 1:
                    System.out.println("coffee initiated");
                    break;
                case 2:
                    System.out.println("sign initiated");
                    break;
                case 3:
                    System.out.println("trash initiated");
                    break;
                case 4:
                    System.out.println("bakery initiated");
                    break;
                case 5:
                    System.out.println("fruit initiated");
                    break;
                case 6:
                    System.out.println("soup initiated");
                    break;
                case 7:
                    System.out.println("cooler initiated");
                    break;

            }

        }
    }
    
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
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public String getAnimation() {
        return animation;
    }

    public void setStations(Rectangle counter, Rectangle coffee, Rectangle sign,
            Rectangle trash, Rectangle bakery, Rectangle fruit, Rectangle soup,
            Rectangle cooler) {
        stations.add(counter);
        stations.add(coffee);
        stations.add(sign);
        stations.add(trash);
        stations.add(bakery);
        stations.add(fruit);
        stations.add(soup);
        stations.add(cooler);
    }

    

}
