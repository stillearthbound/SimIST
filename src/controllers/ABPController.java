package controllers;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import views.*;
import models.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ComponentEvent;
import javax.swing.*;

/**
 *
 * @author Paul
 */
public class ABPController {

    private AuBonPainPanel abp;
    private Timer gameTimer;
    private Customer student;
    private CharacterMovement charMovement;
    private FoodStations stations;
    private Randomize randomize;
    private MenuPanel menuPanel;
    private Inventory inventory;
    private CharacterInventory charInventory;
    private TestFrame testFrame;

    public ABPController() throws Exception {
        testFrame = new TestFrame();
        student = new Customer(testFrame.getSize());
        charMovement = new CharacterMovement();
        stations = new FoodStations();
        abp = new AuBonPainPanel(student, charMovement);
        abp.setFocusable(true);
        randomize = new Randomize();
        menuPanel = new MenuPanel();
        charInventory = new CharacterInventory();
        inventory = new Inventory();

        testFrame.add(abp, BorderLayout.CENTER);

        addKeyListeners();

        InputStream is;
        Sequencer sequence;
        sequence = MidiSystem.getSequencer();
        sequence.open();
        is = new BufferedInputStream(new FileInputStream(new File("beatit.mid")));
        sequence.setSequence(is);
        sequence.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        sequence.start();
        is.close();

    }

    private void addKeyListeners() {
        /*
         STARTING TIMER
         */
        gameTimer = new Timer(5, new GameTimer());
        gameTimer.start();

        /*
         SETTING LISTENERS ON BUTTONS FOR ADDING/SUBTRACTING/USING FROM INVENTORY
         */
        menuPanel.addItemsToInv(new AddItemListener());
        menuPanel.removeItemsFromInv(new RemoveItemListener());
        inventory.addUseListener(new UseItemListener());

        /*
         SETTING KEYLISTENERS ON THE PANEL TO DETECT MOVEMENT
         */
        abp.requestFocusInWindow();
        abp.addKeyListener(new MovementKeyListener());
        abp.addKeyListener(new InteractKeyListener());
        
        /*
          ADD THE RESIZING LISTENER ON FRAME
        */
        
        testFrame.addComponentListener(new Resizer());

    }

    /*
    
     TIMER RUNS EVERY .05 SECONDS TO REFRESH

     */
    class GameTimer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            abp.repaint();

            if (inventory != null) {
                inventory.getContainer().repaint();
            }

        }
    }

    /*
    
     ADD ITEM FROM STATION BUTTON
    
     */
    public class AddItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            StoreObjects[] objectsTemp = menuPanel.getStoreObjects();
            
            for (int i = 0; i < objectsTemp.length; i++) {
                charInventory.addItem(objectsTemp[i], menuPanel.getSpinnerValue(i));
                
            }
            menuPanel.dispose();
        }
    }

    /*
    
     REMOVE ITEM FROM STATION BUTTON
    
     */
    public class RemoveItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ArrayList<StoreObjects> toRemove = new ArrayList<>();
            for (StoreObjects item : charInventory.getInventoryObjects()) {
                charInventory.removeItem(item, menuPanel.getSpinnerValue(charInventory.getInventoryObjects().indexOf(item)));
                if (charInventory.getMap().get(item.getName()) < 1) {
                    toRemove.add(item);
                    //charInventory.getInventoryObjects().remove(charInventory.getInventoryObjects().indexOf(item));
                }

            }
            for (StoreObjects remove : toRemove) {
                charInventory.getInventoryObjects().remove(remove);
                charInventory.getMap().remove((String) remove.getName());
            }
            menuPanel.dispose();

        }
    }

    /*
    
     USE ITEM FROM INVENTORY
    
     */
    public class UseItemListener implements ActionListener {

        public UseItemListener() {

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            charInventory.removeItem(inventory.getItemSelected(), 1.0);

            if (charInventory.getMap().get(inventory.getItemSelected().getName()) < 1) {
                charInventory.getInventoryObjects().remove(inventory.getItemSelected());
                charInventory.getMap().remove((String) inventory.getItemSelected().getName());
                inventory.getSideBar().removeAll();
            }

            inventory.popUpInventory(charInventory);
            inventory.getSideBar().repaint();

        }
    }

    /*
    
     MOVEMENT LISTENER, INPUT ARRAYLIST OF RECTANGLES FOR COLLISION
    
     */
    public class MovementKeyListener implements KeyListener {

        public MovementKeyListener() {

        }

        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            double tempLeftRight = testFrame.getWidth() * .00625;
            double tempUpDown = testFrame.getHeight() * .00833333;

            if (menuPanel != null) {
                menuPanel.dispose();
            }
            if (inventory != null) {
                inventory.dispose();
            }
            int oldX = student.x;
            int oldY = student.y;

            if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D) {
                if (charMovement.getFrame() < 5) {
                    charMovement.setAnimation(student.getAnimation()[0]);
                    charMovement.setFrame(charMovement.getFrame() + 1);
                } else if (charMovement.getFrame() >= 5 && charMovement.getFrame() < 10) {
                    charMovement.setAnimation(student.getAnimation()[1]);
                    charMovement.setFrame(charMovement.getFrame() + 1);
                } else if (charMovement.getFrame() > 9) {
                    charMovement.setFrame(0);
                }
                student.x = student.x + (int) tempLeftRight;
            } else if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A) {

                if (charMovement.getFrame() < 5) {
                    charMovement.setAnimation(student.getAnimation()[2]);
                    charMovement.setFrame(charMovement.getFrame() + 1);
                } else if (charMovement.getFrame() >= 5 && charMovement.getFrame() < 10) {
                    charMovement.setAnimation(student.getAnimation()[3]);
                    charMovement.setFrame(charMovement.getFrame() + 1);
                } else if (charMovement.getFrame() > 9) {
                    charMovement.setFrame(0);
                }
                student.x = student.x - (int) tempLeftRight;
            } else if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W) {
                if (charMovement.getFrame() < 5) {
                    charMovement.setAnimation(student.getAnimation()[4]);
                    charMovement.setFrame(charMovement.getFrame() + 1);
                } else if (charMovement.getFrame() >= 5 && charMovement.getFrame() < 10) {
                    charMovement.setAnimation(student.getAnimation()[5]);
                    charMovement.setFrame(charMovement.getFrame() + 1);
                } else if (charMovement.getFrame() > 9) {
                    charMovement.setFrame(0);
                }
                student.y = student.y - (int) tempUpDown;
            } else if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S) {
                if (charMovement.getFrame() < 5) {
                    charMovement.setAnimation(student.getAnimation()[6]);
                    charMovement.setFrame(charMovement.getFrame() + 1);
                } else if (charMovement.getFrame() >= 5 && charMovement.getFrame() < 10) {
                    charMovement.setAnimation(student.getAnimation()[7]);
                    charMovement.setFrame(charMovement.getFrame() + 1);
                } else if (charMovement.getFrame() > 9) {
                    charMovement.setFrame(0);
                }
                student.y = student.y + (int) tempUpDown;
            }

            /*
            
             PRESSING 'I' POPS UP INVENTORY
            
             */
            if (ke.getKeyCode() == KeyEvent.VK_I) {
                inventory.popUpInventory(charInventory);
                inventory.setLocationRelativeTo(abp);
            }

            if (!charMovement.getAnimation().equals(charMovement.getFacing())) {
                charMovement.setIsInteracting(false);
            }
            abp.refreshStations();
            for (Rectangle station : abp.getStations()) {
                if (student.intersects(station)) {
                    student.x = oldX;
                    student.y = oldY;

                    charMovement.setIsInteracting(true);
                    charMovement.setFacing(charMovement.getAnimation());
                    charMovement.setStationNumber(abp.getStations().indexOf(station));

                }

            }

        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    }

    /*
    
     INTERACTING WITH STATIONS
    
     */
    public class InteractKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (menuPanel != null) {
                menuPanel.dispose();
            }

            if (ke.getKeyCode() == KeyEvent.VK_SPACE && charMovement.getIsInteracting()) {

                switch (charMovement.getStationNumber()) {

                    case 0:
                        System.out.println("counter initiated");

                        break;
                    case 1:
//                            System.out.println("coffee initiated");
                        menuPanel.populateFoodMenu(new CoffeeStation(randomize.getCoffeeObjects()));
                        break;
                    case 2:
//                            System.out.println("sign initiated");
                        break;
                    case 3:
//                            System.out.println("trash initiated");
                        menuPanel.populateTrashMenu(new TrashStation(), charInventory);
                        break;
                    case 4:
//                            System.out.println("bakery initiated");
                        menuPanel.populateFoodMenu(new BreadStation(randomize.getBakeryObjects()));
                        break;
                    case 5:
//                            System.out.println("fruit initiated");
                        menuPanel.populateFoodMenu(new FruitStation(randomize.getFruitObjects()));
                        break;
                    case 6:
//                            System.out.println("soup initiated");
                        menuPanel.populateFoodMenu(new SoupStation(randomize.getSoupObjects()));
                        break;
                    case 7:
//                            System.out.println("cooler initiated");
                        menuPanel.populateFoodMenu(new CoolerStation(randomize.getCoolerObjects()));
                        break;
                    case 8:

                        break;

                }

            }

        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    }

    public class Resizer implements ComponentListener {
        
        
        
        @Override
        public void componentResized(ComponentEvent ce) {
            
            JFrame placeHolder = (JFrame) ce.getSource();
            student.setBounds(placeHolder.getWidth()-student.width*2,Math.round(placeHolder.getHeight()-student.height*2.5f),student.width,student.height);
        }

        @Override
        public void componentMoved(ComponentEvent ce) {

        }

        @Override
        public void componentShown(ComponentEvent ce) {
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
        }

    }
}
