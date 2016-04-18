/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import views.*;

/**
 *
 * @author brianwest
 */
public class FrameTester {

    private final TestFrame frame;

    private JButton auBon;
    private JButton floor;
    private JButton meetingRoom;
    private JButton clockPanel;
    private JButton room206;
    private JButton menuPanel;
    private JButton floor1;
    private JButton cybertorium;

    private ClockPanel clock;

    public FrameTester() {
        frame = new TestFrame();
        frame.setLocationRelativeTo(null);
        setup();
        refreshPane();
    }

    public FrameTester(JPanel panel) {
        frame = new TestFrame();
        frame.getContentPane().add(panel);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

    private void setup() {
        frame.setLayout(new GridLayout(2, 3));

        auBon = new JButton("Au Bon Pain");
        floor = new JButton("Floor");
        meetingRoom = new JButton("MeetingRoom");
        clockPanel = new JButton("ClockPanel");
        room206 = new JButton("Room 206");
        menuPanel = new JButton("MenuPanel");
        floor1 = new JButton("Floor 1");
        cybertorium = new JButton("Cybertorium");

        frame.add(auBon);
//        frame.add(floor);
        frame.add(meetingRoom);
        frame.add(clockPanel);
        frame.add(room206);
//        frame.add(menuPanel);
        frame.add(floor1);
        frame.add(cybertorium);

        auBon.addActionListener(new PanelSwitcher());
        floor.addActionListener(new PanelSwitcher());
        meetingRoom.addActionListener(new PanelSwitcher());
        clockPanel.addActionListener(new PanelSwitcher());
        room206.addActionListener(new PanelSwitcher());
        menuPanel.addActionListener(new PanelSwitcher());
        floor1.addActionListener(new PanelSwitcher());
        cybertorium.addActionListener(new PanelSwitcher());
    }

    private void refreshPane() {
        frame.revalidate();
        frame.repaint();
    }

    private void removeButtons() {
        frame.remove(auBon);
        frame.remove(floor);
        frame.remove(meetingRoom);
    }

    private class PanelSwitcher implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();

            if (o == auBon) {
                try {
                    ABPController c = new ABPController();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }

//            if (o == floor) {
//                removeButtons();
//                Floor floorPanel = new Floor(1);
//                frame.getContentPane().add(floorPanel);
//                floorPanel.setFocusable(true);
//                floorPanel.requestFocusInWindow();
//                refreshPane();
//            }

            if (o == meetingRoom) {
                try {
                    MRController m = new MRController();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }

            if (o == clockPanel) {
                try {
                    FrameTester frame = new FrameTester(new ClockPanel());
                } catch (Exception ex) {
                }
            }
            
            if (o == room206) {
                try {
                    RoomController roomController = new RoomController();
                } catch (Exception ex) {
                }
            }

//            if (o == menuPanel) {
//                try {
//                    MenuPanel menuPanel = new MenuPanel();
//                } catch (Exception ex) {
//                }
//            }
            
            if (o == floor1) {
                try {
                    FrameTester frame = new FrameTester(new Floor1("test", new FloorController()));
                } catch (Exception ex) {
                }
            }
            
            if (o == cybertorium) {
                try {
                    FrameTester frame = new FrameTester(new Cybertorium());
                } catch (Exception ex) {
                }
            }
            
        }
    }
}
