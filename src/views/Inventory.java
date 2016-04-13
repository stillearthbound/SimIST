/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import models.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author greg
 */
public class Inventory extends JFrame{
    private JLabel item;
    private JLabel cost;
    private JLabel quantity;
    private JLabel actualItem;
    private JLabel actualCost;
    private JLabel actualQuantity;
    private JButton grabItems;
    private JSpinner quantSpin;
    private ArrayList<JSpinner> allSpinners = new ArrayList<JSpinner>();
    private int offset = 2;
    private GridBagConstraints layoutConst = new GridBagConstraints();
    private JPanel content = new JPanel();
    
    public Inventory(CharacterInventory charInventory){
        content.setLayout(new GridBagLayout());
        layoutConst.insets = new Insets(10, 10, 10, 10);
       
        item = new JLabel("Item");
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        content.add(item, layoutConst);
        
        quantity = new JLabel("Quantity");
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        content.add(quantity, layoutConst);
        
        cost = new JLabel("Cost");
        layoutConst.gridx = 2;
        layoutConst.gridy = 1;
        content.add(cost, layoutConst);
        
        int i = 0;
        List keys = new ArrayList(charInventory.getMap().keySet());
        List values = new ArrayList(charInventory.getMap().values());
        
                   
        while (i < charInventory.getMap().size()){
            
            actualItem = new JLabel((String)keys.get(i));
            layoutConst.gridx = 0;
            layoutConst.gridy = i + offset;
            content.add(actualItem, layoutConst);
            
            actualQuantity = new JLabel(Integer.toString(charInventory.getMap().get((String)keys.get(i))));
            layoutConst.gridx = 1;
            layoutConst.gridy = i + offset;
            content.add(actualQuantity, layoutConst);
            
//            actualCost = new JLabel(String.format("$%.2f",charInventory.getInventoryObjects().get(i).getCost()));
//            layoutConst.gridx = 2;
//            layoutConst.gridy = i + offset;
//            content.add(actualCost, layoutConst);
            
            i++;
        }
        
        setContentPane(content);
        pack();
        setTitle("CHARACTER INVENTORY");
        setVisible(true);
        setResizable(false);
    }
    
}
