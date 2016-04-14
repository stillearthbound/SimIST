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

    private ArrayList<JButton> items;
    private Box gap;
    private GridBagConstraints layoutConst = new GridBagConstraints();
    private JPanel content;
    private JPanel sideBar;
    private JPanel container;

    public Inventory(CharacterInventory inventory) {

        items = new ArrayList<>();

        setSize(378, 305);
        setTitle("CHARACTER INVENTORY");
        setVisible(true);

        container = new JPanel();
        container.setSize(this.getSize());
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        setContentPane(container);

        content = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                g.drawImage(new ImageIcon("inventory.png").getImage(), 0, 0, (int) Math.round(this.getWidth()), (int) Math.round(container.getHeight()), null);

            }
        };

        sideBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                g.drawImage(new ImageIcon("sidebar.png").getImage(), 0, 0, (int) Math.round(this.getWidth()), (int) Math.round(container.getHeight()), null);

            }
        };

        container.add(content);
        container.add(sideBar);

        content.setPreferredSize(new Dimension((int) Math.round(container.getWidth() * .714), (int) Math.round(container.getHeight() * .885)));

        sideBar.setPreferredSize(new Dimension((int) Math.round(container.getWidth() * .238), (int) Math.round(container.getHeight() * .885)));
        content.setMaximumSize(new Dimension(1000, 1000));
        sideBar.setMaximumSize(new Dimension(1000, 1000));
        getContentPane().setPreferredSize(new Dimension(content.getWidth() + sideBar.getWidth(), content.getHeight() + sideBar.getHeight()));

        content.setLayout(new GridLayout(4, 5));
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        JLabel item = new JLabel("<html><font color='white'>Item</font></font></html>", SwingConstants.CENTER);
        JLabel name = new JLabel("<html><font color='white'>Name</font></font></html>", SwingConstants.CENTER);

        sideBar.add(item);
        sideBar.add(Box.createVerticalStrut(container.getSize().height / 6));
        sideBar.add(name);

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

            items.add(new JButton("<html><font color='white'>" + Integer.toString(inventoryObject.getNumInv()) + "</font></font></html>") {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(itemPic.getImage(), 0, 0, content.getWidth() / 4, content.getHeight() / 4, null);
                }
            ;
            });
            items.get(inventory.getInventoryObjects().indexOf(inventoryObject)).setOpaque(false);
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

    public JPanel getContainer() {
        return container;
    }

}
