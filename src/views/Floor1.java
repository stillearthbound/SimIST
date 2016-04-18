/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.FloorController;
import entities.Room;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.CharacterMovement;
import models.Customer;
import models.RoomEntry;
import models.AbpEntry;

/**
 *
 * @author matthewtucker
 */
public class Floor1 extends JPanel implements ActionListener, KeyListener{

    private String floorName;
    private Image floorImage;
    private Timer refreshTimer;
    private FloorController controller;
    private ArrayList<Room> rooms;
    private ArrayList<RoomEntry> entries;
    private player player1;
    private AbpEntry entry1;
    private AuBonPainPanel abp1;
    private Customer cust1;
    private CharacterMovement charMove1;

    public Floor1(String floorName, FloorController cont1) {
        this.floorName = floorName;
        this.controller = cont1;
        refreshTimer = new Timer(50, this);
        refreshTimer.start();
        rooms = new ArrayList<>();
        entries = new ArrayList<>();

        rooms.add(new Room(202));
        rooms.add(new Room(204));
        rooms.add(new Room(206));
        rooms.add(new Room(208));
        rooms.add(new Room(210));
        entries.add(new RoomEntry(202, 50, 100, rooms.get(0)));
        entries.add(new RoomEntry(204, 50, 150, rooms.get(1)));
        entries.add(new RoomEntry(206, 50, 200, rooms.get(2)));
        entries.add(new RoomEntry(208, 50, 250, rooms.get(3)));
        entries.add(new RoomEntry(210, 50, 300, rooms.get(4)));
        player1 = new player();
        cust1 = new Customer(new Dimension(800, 600));
        charMove1 = new CharacterMovement();
        abp1 = new AuBonPainPanel(cust1, charMove1);
        entry1 = new AbpEntry(1, 450, 50, abp1);
        this.addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 

        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        player1.paintComponent(g);
        for (int i = 0; i < entries.size() - 1; i++) {
            entries.get(i).paintComponent(g);
        }

        entry1.paintComponent(g);

        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).paintComponent(g);
        }

        for (int i = 0; i < entries.size(); i++) {
            if (player1.intersects(entries.get(i))) {
                controller.floorToRoom(entries.get(i).getRoom());

            }
        }
        if (player1.intersects(entry1)) {
           controller.floorToAbp(entry1.getAbpPanel());
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == refreshTimer) {
            this.repaint();
        }
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player1.setDx(-20);

            System.out.println("Typed");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player1.setDx(20);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player1.setDy(-20);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player1.setDy(20);
        }
    }

    public void keyReleased(KeyEvent e) {
        player1.setDx(0);
        player1.setDy(0);
    }

    private class player extends Rectangle {

        private int dx;
        private int dy;

        public player() {
            this.dx = 0;
            this.dy = 0;
            this.setBounds(200, 50, 30, 30);
        }

        public void move() {
            this.x += dx;
            this.y += dy;
        }

        public void setDx(int dx) {
            this.dx = dx;
        }

        public void setDy(int dy) {
            this.dy = dy;
        }

        public void paintComponent(Graphics g) {
            move();
            g.drawRect(x, y, 30, 30);
        }
    }
}
