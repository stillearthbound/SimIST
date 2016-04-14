/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Dimension;
import java.awt.Graphics;
import models.*;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author greg
 */
public class Inventory extends JFrame {

    private JLabel item;
    private JLabel cost;
    private JLabel quantity;
    private JLabel actualItem;
    private JLabel actualCost;
    private JLabel actualQuantity;
    private ArrayList<JButton> items;
    private int offset = 2;
    private GridBagConstraints layoutConst = new GridBagConstraints();
    private JPanel content;
    private JPanel sideBar;

    public Inventory(CharacterInventory inventory) {

        content = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                g.drawImage(new ImageIcon("inventory.png").getImage(), 0, 0, null);

            }
        };

        sideBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                g.drawImage(new ImageIcon("sidebar.png").getImage(), 0, 0, null);

            }
        };

        setSize(378, 305);
        JPanel container = new JPanel();
        container.setSize(this.getSize());
        items = new ArrayList<>();
        add(container);
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(content);
        container.add(sideBar);
        content.setPreferredSize(new Dimension(270, 270));
        content.setMinimumSize(content.getPreferredSize());
        content.setMaximumSize(content.getPreferredSize());

        sideBar.setPreferredSize(new Dimension(90, 270));
        sideBar.setMinimumSize(content.getPreferredSize());
        sideBar.setMaximumSize(content.getPreferredSize());

        setTitle("CHARACTER INVENTORY");
        setVisible(true);
        setResizable(false);

        content.setLayout(new GridLayout(4, 5));
        sideBar.setLayout(null);
        item = new JLabel("<html><font color='white'>Item</font></html>");
        item.setBounds(35, 20, 50, 20);

        sideBar.add(item);
        layoutConst.fill = GridBagConstraints.CENTER;

//        while (i < inventory.getInventoryObjects().size()) {
//
//            actualItem = new JLabel(inventory.getInventoryObjects().get(i).getName());
//            layoutConst.gridx = 1;
//            layoutConst.gridy = i ;
//            sideBar.add(actualItem, layoutConst);
//
//            actualQuantity = new JLabel(Integer.toString(inventory! .getInventoryObjects().get(i).getQuantity()));
//            layoutConst.gridx = 1;
//            layoutConst.gridy = i;
//            sideBar.add(actualQuantity, layoutConst);
//
//            actualCost = new JLabel(String.format("$%.2f", inventory.getInventoryObjects().get(i).getCost()));
//            layoutConst.gridx = 1;
//            layoutConst.gridy = i ;
//            sideBar.add(actualCost, layoutConst);
//
//            i++;
//        }
        int numItems = 0;
        int i = 0;
        for (StoreObjects inventoryObject : inventory.getInventoryObjects()) {

            final ImageIcon itemPic = new ImageIcon(inventoryObject.getFilePath());

            items.add(new JButton("<html><font color='white'>" + Integer.toString(inventoryObject.getNumInv()) + "</font></html>") {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(itemPic.getImage(), 15, 15, 40, 40, null);
                }
            ;
            });
            items.get(inventory.getInventoryObjects().indexOf(inventoryObject)).setOpaque(false);
            // items.get(inventory.getInventoryObjects().indexOf(inventoryObject)).setIcon(itemPic);
            items.get(inventory.getInventoryObjects().indexOf(inventoryObject)).setContentAreaFilled(false);
            items.get(inventory.getInventoryObjects().indexOf(inventoryObject)).setFocusPainted(false);
            items.get(inventory.getInventoryObjects().indexOf(inventoryObject)).setHorizontalAlignment(SwingConstants.RIGHT);
            items.get(inventory.getInventoryObjects().indexOf(inventoryObject)).setVerticalAlignment(SwingConstants.BOTTOM);
            content.add(items.get(inventory.getInventoryObjects().indexOf(inventoryObject)));

            numItems += inventoryObject.getNumInv();
        }

        System.out.println(numItems);
        while (i < (16) - items.size()) {

            JButton empty = new JButton();

            empty.setOpaque(false);
            empty.setContentAreaFilled(false);
            empty.setFocusPainted(false);

            content.add(empty, layoutConst);

            i++;
        }
    }

}
