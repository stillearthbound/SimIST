///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package views;
//
//import models.*;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class AuBonPainPanel extends JPanel {
//
//    private Rectangle counter;
//    private Rectangle coffee;
//    private Rectangle sign;
//    private Rectangle trash;
//    private Rectangle bakery;
//    private Rectangle fruit;
//    private Rectangle soup;
//    private Rectangle cooler;
//    private Rectangle exitOutside;
//    private Rectangle exitCompSci;
//    private CharacterMovement characterMovement;
//    private Customer student;
//
//    private JLabel temp = new JLabel();
//
//    public AuBonPainPanel(Customer inf_Student, CharacterMovement inf_charMovement) {
//        super();
//        student = inf_Student;
//        characterMovement = inf_charMovement;
//        setSize(800, 600);
//        setLayout(null);
//        add(temp);
//        temp.setBounds(200, 200, 200, 200);
//        init();
//        placeStations();
//        this.addKeyListener(characterMovement);
//
//        this.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e)
//            {
//                System.out.println(e.getPoint());
//                temp.setText(e.getPoint().toString());
//            }
//        });
//        this.setFocusable(true);
//    }
//
//    private void init() {
//
//        counter = new Rectangle();
//
//        coffee = new Rectangle();
//
//        sign = new Rectangle();
//
//        trash = new Rectangle();
//
//        bakery = new Rectangle();
//
//        fruit = new Rectangle();
//
//        soup = new Rectangle();
//
//        cooler = new Rectangle();
//
//    }
//
//    private void placeStations() {
//        student.setBounds(700, 400, student.width, student.height);
//        counter.setBounds(622, 158, 160, 192);
//        coffee.setBounds(201, 513, 309, 40);
//        sign.setBounds(86, 355, 50, 45);
//        trash.setBounds(59, 492, 114, 62);
//        bakery.setBounds(5, 132, 50, 150);
//        fruit.setBounds(28, 5, 75, 65);
//        soup.setBounds(146, 17, 144, 40);
//        cooler.setBounds(318, 26, 310, 30);
//
//    }
//    
//    public Rectangle getCounter()
//    {
//        return counter;
//    }
//    
//    public Rectangle getCoffee()
//    {
//        return coffee;
//    }
//    
//    public Rectangle getSign()
//    {
//        return sign;
//    }
//    
//    public Rectangle getTrash()
//    {
//        return trash;
//    }
//    
//    public Rectangle getBakery()
//    {
//        return bakery;
//    }
//    
//    public Rectangle getFruit()
//    {
//        return fruit;
//    }
//    
//    public Rectangle getSoup()
//    {
//        return soup;
//    }
//    
//    public Rectangle getCooler()
//    {
//        return cooler;
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//
//        super.paintComponent(g);
//
//        g.drawImage(new ImageIcon("floor.png").getImage(), 0, 0, null);
//        g.drawImage(new ImageIcon(characterMovement.getAnimation()).getImage(), student.x, student.y, null);
//
//    }
//
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ABPController;
import models.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AuBonPainPanel extends JPanel {
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

    public AuBonPainPanel(Customer inf_Student, CharacterMovement inf_charMovement) {
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
    
    public Rectangle getCounter()
    {
        return counter;
    }
    
    public Rectangle getCoffee()
    {
        return coffee;
    }
    
    public Rectangle getSign()
    {
        return sign;
    }
    
    public Rectangle getTrash()
    {
        return trash;
    }
    
    public Rectangle getBakery()
    {
        return bakery;
    }
    
    public Rectangle getFruit()
    {
        return fruit;
    }
    
    public Rectangle getSoup()
    {
        return soup;
    }
    
    public Rectangle getCooler()
    {
        return cooler;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(new ImageIcon("floor.png").getImage(), 0, 0, null);
        g.drawImage(new ImageIcon(characterMovement.getAnimation()).getImage(), student.x, student.y, null);

    }

}
