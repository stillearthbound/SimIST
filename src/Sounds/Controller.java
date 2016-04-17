/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sounds;
import sun.audio.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Qiu
 */
public class Controller{
    private Model model;
    private View view;
    private ActionListener actionListener;
    public MyKeyListener keylisten;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.getFrame().addKeyListener(new MyKeyListener());
        
    }
    public void ButtonControl(){
        actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                onClick();
            }
        };
        view.getButton().addActionListener(actionListener);

    }
    private void onClick(){
        model.buttonSound();
        System.out.println("clicked");
        view.getFrame().requestFocus();
    }
    
    
    
    //Refrences:http://staticvoidgames.com/tutorials/swing/listeners
    public class MyKeyListener implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyChar();
        if (i == KeyEvent.VK_RIGHT ) {
            System.out.println("Right pressed.");
        } 
        else if (i == KeyEvent.VK_LEFT ) {
            System.out.println("Left pressed.");
        } 
        else if (i == KeyEvent.VK_UP ) {
            System.out.println("Up pressed.");
        } 
        else if (i == KeyEvent.VK_DOWN ) {
            System.out.println("Down pressed.");
        }
        else{
            System.out.println("Key pressed: " + e.getKeyChar());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            System.out.println("Right released.");
            model.playRightKey();
        } 
        else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            System.out.println("Left released.");
            model.playLeftKey();
        } 
        else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            System.out.println("Up released.");
            model.playUpKey();
        } 
        else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            System.out.println("Down released.");
            model.playDownKey();
        }
        else{
            System.out.println("Key released: " + e.getKeyChar());
        }
    }   
    }
}

