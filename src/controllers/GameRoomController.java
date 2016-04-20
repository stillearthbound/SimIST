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
public class GameRoomController {

    private GameRoom room;
    private Timer gameTimer;
    private Customer student;
    private CharacterMovement charMovement;
    private FoodStations stations;
    private Randomize randomize;
    private MenuPanel menuPanel;
    private Inventory inventory;
    private TestFrame testFrame;
    private static Timer signTimer;
    private StoreObjects signObject;
    private static final int CHANGE_INTERVAL = 900000;
    protected Sequencer sequence;

    public GameRoomController(Customer inf_student, GameRoom inf_room) throws Exception {
        testFrame = new TestFrame();

        student = inf_student;
        stations = new FoodStations();
        room = inf_room;
        testFrame.setSize(room.getSize());
        room.setFocusable(true);
        randomize = new Randomize();
        menuPanel = new MenuPanel();
        inventory = new Inventory();
        charMovement = new CharacterMovement(student, room, inventory);
        testFrame.add(room, BorderLayout.CENTER);
        
        signObject = randomize.getRandObject(randomize.getAllFood());
        signObject.changeCost((float) (signObject.getCost() * .85));
 
        addKeyListeners();

        InputStream is;
        sequence = MidiSystem.getSequencer();
        sequence.open();
        is = new BufferedInputStream(new FileInputStream(new File("jamiroquai-canned_heat.mid")));
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
        signTimer = new Timer(CHANGE_INTERVAL, new SignTimer());
        signTimer.start();

        /*
         SETTING LISTENERS ON BUTTONS FOR ADDING/SUBTRACTING/USING FROM INVENTORY
         */
        menuPanel.addItemsToInv(new AddItemListener());
        menuPanel.removeItemsFromInv(new RemoveItemListener());
        inventory.addUseListener(new UseItemListener());

        /*
         SETTING KEYLISTENERS ON THE PANEL TO DETECT MOVEMENT
         */
        room.requestFocusInWindow();
        room.addKeyListener(charMovement);
        room.addKeyListener(new InteractKeyListener());

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

            room.repaint();

            if (inventory != null) {
                inventory.getContainer().repaint();
            }

        }
    }

    class SignTimer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.printf("%s price returned from $%.2f", signObject.getName(), signObject.getCost());
            signObject.changeCost((float) (signObject.getCost() * 1.176470588));
            System.out.printf(" to $%.2f\n", signObject.getCost());
            
            signObject = randomize.getRandObject(randomize.getAllFood());
            System.out.println("Food Object: " + signObject.getName());
            System.out.printf("Price changed from $%.2f", signObject.getCost());
            signObject.changeCost((float) (signObject.getCost() * .85));
            System.out.printf(" to $%.2f\n", signObject.getCost());
        }
        // Got rid of duplicate code here. George
    }
    

    /*
    
     ADD ITEM FROM STATION BUTTON
    
     */

    public class AddItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            StoreObjects[] objectsTemp = menuPanel.getStoreObjects();

            for (int i = 0; i < objectsTemp.length; i++) {
                student.getInventory().addItem(objectsTemp[i], menuPanel.getSpinnerValue(i));

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
            for (StoreObjects item : student.getInventory().getInventoryObjects()) {
                student.getInventory().removeItem(item, menuPanel.getSpinnerValue(student.getInventory().getInventoryObjects().indexOf(item)));
                if (student.getInventory().getMap().get(item.getName()) < 1) {
                    toRemove.add(item);
                    //charInventory.getInventoryObjects().remove(charInventory.getInventoryObjects().indexOf(item));
                }

            }
            for (StoreObjects remove : toRemove) {
                student.getInventory().getInventoryObjects().remove(remove);
                student.getInventory().getMap().remove((String) remove.getName());
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
            student.getInventory().removeItem(inventory.getItemSelected(), 1.0);
            
            if (student.getInventory().getMap().get(inventory.getItemSelected().getName()) < 1) {
                student.getInventory().getInventoryObjects().remove(inventory.getItemSelected());
                student.getInventory().getMap().remove((String) inventory.getItemSelected().getName());
                inventory.getSideBar().removeAll();
            }

            inventory.popUpInventory(student.getInventory());
            inventory.getSideBar().repaint();

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
            if (room instanceof AuBonPainPanel) {
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
                        menuPanel.populateSignMenu(signObject.getName(), signObject.getCost());
                        break;
                    case 3:
//                            System.out.println("trash initiated");
                        menuPanel.populateTrashMenu(new TrashStation(), student.getInventory());
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

        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    }

    public class Resizer implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent ce) {

            JFrame placeHolder = (JFrame) ce.getSource();
            if (room instanceof AuBonPainPanel) {
                student.setBounds(placeHolder.getWidth() - student.width * 2, Math.round(placeHolder.getHeight() - student.height * 2.5f), student.width, student.height);
            }
        }

        @Override
        public void componentMoved(ComponentEvent ce) {

        }

        @Override
        public void componentShown(ComponentEvent ce) {
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
            sequence.stop();
            testFrame.dispose();
        }

    }
}
