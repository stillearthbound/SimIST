/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

/**
 *
 * @author laurenritter
 */
public class TwitterController {
    private ManualTwitterUI theManualTwitterUI;
    
    public TwitterController(){
        theManualTwitterUI = new ManualTwitterUI();
        theManualTwitterUI.setVisible(true);
    }
}
