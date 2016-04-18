/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import models.Customer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jon
 */
public class MeetingRoomPanel extends GameRoom {

    public static final int TABLEWIDTH = 410;
    public static final int TABLEHEIGHT = 58;
    public static final int PROJECTORWIDTH = 300;
    public static final int PROJECTORHEIGHT = 300;

    private Rectangle table;
    private Rectangle projector;
    private Customer student;

    public MeetingRoomPanel(Customer inf_Student) {
        super();
        student = inf_Student;
        setSize(800, 600);
        setLayout(null);
        init();
        placeStations();

        this.setFocusable(true);
    }

    private void init() {
        table = new Rectangle();
        projector = new Rectangle();
    }

    private void placeStations() {
        student.setBounds(400, 500, student.width, student.height);
        table.setBounds(180, 245, TABLEWIDTH, TABLEHEIGHT);
        projector.setBounds(670, 400, PROJECTORWIDTH, PROJECTORHEIGHT);
    }

    public Rectangle getTable() {
        return table;
    }

    public Rectangle getProjector() {
        return projector;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(new ImageIcon("meetingRoom.png").getImage(), 0, 0, null);
        g.drawImage(new ImageIcon(student.getAnimation()).getImage(), student.x, student.y, null);

    }

    @Override
    public ArrayList<Rectangle> getStations() {

        return new ArrayList<>(Arrays.asList(table, projector));
    }

}
