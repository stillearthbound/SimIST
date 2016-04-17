/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Customer;
import models.MeetingRoomMovement;
import java.awt.event.KeyListener;

/**
 *
 * @author Jon
 */

public class MeetingRoomPanel extends JPanel {
    public static final int TABLEWIDTH = 410;
    public static final int TABLEHEIGHT = 58;
    public static final int PROJECTORWIDTH = 300;
    public static final int PROJECTORHEIGHT = 300;

    private Rectangle table;
    private Rectangle projector;
    private MeetingRoomMovement characterMovement;
    private Customer student;

    private JLabel temp = new JLabel();

    public MeetingRoomPanel(Customer inf_Student, MeetingRoomMovement inf_charMovement) {
        super();
        student = inf_Student;
        characterMovement = inf_charMovement;
        setSize(800, 600);
        setLayout(null);
        add(temp);
        temp.setBounds(200, 200, 200, 200);
        init();
        placeStations();
        this.addKeyListener(characterMovement);

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e)
            {
//                System.out.println(e.getPoint());
                temp.setText(e.getPoint().toString());
            }
        });
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
    
    public Rectangle getTable()
    {
        return table;
    }
    
    public Rectangle getProjector()
    {
        return projector;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(new ImageIcon("meetingRoom.png").getImage(), 0, 0, null);
        g.drawImage(new ImageIcon(characterMovement.getAnimation()).getImage(), student.x, student.y, null);

    }

}
