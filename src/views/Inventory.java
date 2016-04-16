/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Dimension;
import java.awt.Graphics;
import models.*;
import java.awt.event.ActionListener;

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
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author greg
 */
public class Inventory extends JFrame implements ComponentListener{

    private ArrayList<JButton> items;
    private GridBagConstraints layoutConst = new GridBagConstraints();
    protected StoreObjects itemSelected;
    private JPanel content;
    private JPanel sideBar;
    private JPanel container;
    private JButton useItem = new JButton("USE ITEM");
    protected CharacterInventory inventory;

    public Inventory() {

        items = new ArrayList<>();

        setSize(520,400);
        setTitle("CHARACTER INVENTORY");

        container = new JPanel();
        container.setSize(this.getSize());
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        setContentPane(container);
        getContentPane().setPreferredSize(new Dimension(520, 400));
        pack();

        content = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                getParent().getParent().requestFocus();
                g.drawImage(new ImageIcon("inventory.png").getImage(), 0, 0, (int) Math.round(this.getWidth()), (int) Math.round(container.getHeight()), null);
            }
        };

        sideBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                getParent().getParent().requestFocus();
                g.drawImage(new ImageIcon("sidebar.png").getImage(), 0, 0, (int) Math.round(this.getWidth()), (int) Math.round(container.getHeight()), null);

            }
        };

        container.add(content);
        container.add(sideBar);

        container.setFocusable(false);
        content.setFocusable(false);
        sideBar.setFocusable(false);

        content.setPreferredSize(new Dimension((int) Math.round(container.getWidth() * .714), (int) Math.round(container.getHeight() * .885)));

        sideBar.setPreferredSize(new Dimension((int) Math.round(container.getWidth() * .238), (int) Math.round(container.getHeight() * .885)));
        content.setMaximumSize(new Dimension(1000, 1000));
        sideBar.setMaximumSize(new Dimension(1000, 1000));
        getContentPane().setPreferredSize(new Dimension(content.getWidth() + sideBar.getWidth(), content.getHeight() + sideBar.getHeight()));

        content.setLayout(new GridLayout(4, 5));
        sideBar.setLayout(new GridBagLayout());

    }

    public void popUpInventory(CharacterInventory inf_inventory) {
        setVisible(true);
        inventory = inf_inventory;
        items.clear();
        content.removeAll();
        for (StoreObjects inventoryObject : inventory.getInventoryObjects()) {

            final ImageIcon itemPic = new ImageIcon(inventoryObject.getFilePath());

            items.add(new JButton("<html><font color='white'>" + Integer.toString(inventory.getMap().get((String) inventoryObject.getName())) + "</font></font></html>") {
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
            items.get(inventory.getInventoryObjects().indexOf(inventoryObject)).addActionListener(new ItemListener(inventoryObject));
            content.add(items.get(inventory.getInventoryObjects().indexOf(inventoryObject)));

        }

        int i = 0;
        while (i < (16) - items.size()) {

            JButton empty = new JButton();

            empty.setOpaque(false);
            empty.setContentAreaFilled(false);
            empty.setFocusPainted(false);

            content.add(empty, layoutConst);

            i++;
        }

        container.repaint();
        container.revalidate();

    }

    public void addUseListener(ActionListener al) {
        useItem.addActionListener(al);
    }

    public JPanel getContainer() {
        return container;
    }

    public JPanel getSideBar() {

        return sideBar;
    }


    public StoreObjects getItemSelected() {
        return itemSelected;
    }

    @Override
    public void componentResized(ComponentEvent ce) {
        sideBar.repaint();
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }

    public class CloseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

        }
    }

    public class ItemListener implements ActionListener {

        private StoreObjects item;

        public ItemListener(StoreObjects inf_inventoryObject) {

            item = inf_inventoryObject;

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            GridBagConstraints layoutConst = new GridBagConstraints();
            itemSelected = item;
            JLabel title = new JLabel("<html><font color='white'>Name: </font></font></html>", SwingConstants.CENTER);
            JLabel name = new JLabel("<html><font color='white'>" + item.getName() + "</font></font></html>", SwingConstants.CENTER);
            JLabel cost = new JLabel("<html><font color='white'>Total Cost: </font></font></html>", SwingConstants.CENTER);
            JLabel itemCost = new JLabel(String.format("<html><font color='white'>$%.2f", item.getCost()*inventory.getMap().get((String)item.getName())) + "</font></font></html>", SwingConstants.CENTER);
            JLabel paidFor = new JLabel("<html><font color='white'>Paid For: </font></font></html>", SwingConstants.CENTER);
            JLabel itemPaidFor = new JLabel("<html><font color='white'>" + item.getPaidFor() + "</font></font></html>", SwingConstants.CENTER);
            useItem.setPreferredSize(new Dimension(sideBar.getSize().width, sideBar.getSize().height / 4));
            sideBar.removeAll();
            layoutConst.gridx = 1;
            layoutConst.gridy = GridBagConstraints.RELATIVE;
            layoutConst.anchor = GridBagConstraints.NORTH;
            
            inventory.getMap().get((String)item.getName());

            //ADDING LABELS
            sideBar.add(title, layoutConst);
            sideBar.add(name, layoutConst);
            sideBar.add(Box.createVerticalStrut(container.getSize().height / 8), layoutConst);

            sideBar.add(cost, layoutConst);
            sideBar.add(itemCost, layoutConst);
            sideBar.add(Box.createVerticalStrut(container.getSize().height / 8), layoutConst);

            sideBar.add(paidFor, layoutConst);
            sideBar.add(itemPaidFor, layoutConst);
            sideBar.add(Box.createVerticalStrut(container.getSize().height / 8), layoutConst);

            sideBar.add(useItem, layoutConst);

            sideBar.repaint();
            sideBar.revalidate();
        }

    }

}
