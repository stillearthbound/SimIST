package views;

import controllers.ClassroomController;
import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import models.*;

/**
 *
 * @author junggue
 */
public class ClassroomPanel extends JPanel {

    private final int CLASS_WIDTH = 700;
    private final int CLASS_HEIGHT = 700;

    //character starting point
    private final int x = 90;
    private final int y = 280;

    private Path2D.Double parallelogram;

    private JLabel mousePointerInfo;

    private ClassroomController theClassroomController;

    public ClassroomPanel(ClassroomController parentController) {
        super();

        theClassroomController = parentController;

        setSize(CLASS_WIDTH, CLASS_HEIGHT);

//        theClassroomController.getCustomer().setBounds
//        (70,300, theClassroomController.getCustomer().width, theClassroomController.getCustomer().height);
        mousePointerInfo = new JLabel();
        add(mousePointerInfo);
        mousePointerInfo.setBounds(200, 200, 200, 200);
        setVisible(true);

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
//                System.out.println(e.getPoint());
                mousePointerInfo.setText(e.getPoint().toString());
            }
        });

        //this.addKeyListener(theClassroomController.getCharacterMovement());
        this.setFocusable(true);

    }

    // reference: http://stackoverflow.com/questions/28017537/how-do-you-draw-and-fill-a-parallelogram-in-java-swing
    // I learned how to create diverse shape form other than rectangles and circles from the above link
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        Graphics2D twoD = (Graphics2D) g;
//        twoD.setColor(Color.BLACK);
//        twoD.fill(parallelogram);

        g.drawImage(new ImageIcon("classroom_render.png").getImage(), 0, 0, this);
//        g.drawImage(new ImageIcon(theClassroomController.getCharacterMovement().getAnimation()).getImage(), 
//                theClassroomController.getCustomer().x, theClassroomController.getCustomer().y, null);
//    }'=
    }

}
