package views;

import controllers.ABPController;
import models.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.util.*;

public   class AuBonPainPanel extends JPanel {
    public static final int COUNTERWIDTH = 160;
    public static final int COUNTERHEIGHT = 192;
    public static final int COFFEEWIDTH = 309;
    public static final int COFFEEHEIGHT = 40;
    public static final int SIGNWIDTH = 50;
    public static final int SIGNHEIGHT = 45;
    public static final int TRASHWIDTH = 114;
    public static final int TRASHHEIGHT = 62;
    public static final int BAKERYWIDTH = 50;
    public static final int BAKERYHEIGHT = 150;
    public static final int FRUITWIDTH = 75;
    public static final int FRUITHEIGHT = 65;
    public static final int SOUPWIDTH = 144;
    public static final int SOUPHEIGHT = 40;
    public static final int COOLERWIDTH = 310;
    public static final int COOLERHEIGHT = 30;

    private Rectangle counter;
    private Rectangle coffee;
    private Rectangle sign;
    private Rectangle trash;
    private Rectangle bakery;
    private Rectangle fruit;
    private Rectangle soup;
    private Rectangle cooler;
    private Rectangle exitOutside;
    private Rectangle exitCompSci;
    private CharacterMovement characterMovement;
    private Customer student;

    private JLabel temp = new JLabel();

    public AuBonPainPanel(Customer inf_Student, CharacterMovement inf_characterMovement) {
        super();
        student = inf_Student;
        setSize(800, 600);
        setLayout(null);
        add(temp);
        temp.setBounds(200, 200, 200, 200);
        init();
        placeStations();
        characterMovement = inf_characterMovement;
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
        counter = new Rectangle();
        coffee = new Rectangle();
        sign = new Rectangle();
        trash = new Rectangle();
        bakery = new Rectangle();
        fruit = new Rectangle();
        soup = new Rectangle();
        cooler = new Rectangle();
        
        
    }

    private void placeStations() {
        student.setBounds(700, 400, student.width, student.height);
        counter.setBounds(622, 158, COUNTERWIDTH, COUNTERHEIGHT);
        coffee.setBounds(201, 513, COFFEEWIDTH, COFFEEHEIGHT);
        sign.setBounds(86, 355, SIGNWIDTH, SIGNHEIGHT);
        trash.setBounds(59, 492, TRASHWIDTH, TRASHHEIGHT);
        bakery.setBounds(5, 132, BAKERYWIDTH, BAKERYHEIGHT);
        fruit.setBounds(28, 5, FRUITWIDTH, FRUITHEIGHT);
        soup.setBounds(146, 17, SOUPWIDTH, SOUPHEIGHT);
        cooler.setBounds(318, 26, COOLERWIDTH, COOLERHEIGHT);

    }
    
    public ArrayList<Rectangle> getStations()
    {
        return new ArrayList<>(Arrays.asList(counter, coffee, sign, trash, bakery, fruit, soup, cooler));
    }
    
    public void setKeyListener(KeyListener kl)
    {
        addKeyListener(kl);
    }
    

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(new ImageIcon("floor.png").getImage(), 0, 0, null);
        g.drawImage(new ImageIcon(characterMovement.getAnimation()).getImage(), student.x, student.y, null);

    }

}
