/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author Jon
 */
//This class is a demonstration of how people will interact with one another
public class Behavior {
    
    private Person person1;
    private Person person2;
    
    public Behavior(Person person1, Person person2){
        this.person1 = person1;
        this.person2 = person2;
    }
    
//    public void socialize(){
//        person1.setStress(person1.getStress() - 1);
//        person2.setStress(person2.getStress() - 1);
//    }
//    
//    public void groupStudy(){
//        person1.setIntelligence(person1.getIntelligence() + 1);
//        person2.setIntelligence(person2.getIntelligence() + 1);
//    }
//    
//    public void pepTalk(){
//        if(person1.getDisipline() > person2.getDisipline()){
//            person2.setDisipline(person2.getDisipline() + 2);
//        }else if(person1.getDisipline() == person2.getDisipline()){
//            person1.setDisipline(person1.getDisipline() + 1);
//            person2.setDisipline(person2.getDisipline() + 1);
//        }else{
//            person1.setDisipline(person1.getDisipline() + 2);
//        }
//    }
    
}
