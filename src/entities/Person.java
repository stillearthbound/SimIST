
package entities;

import java.util.ArrayList;

public class Person {
    private String fName;
    private String lName;
    private int age;
    private ArrayList<String> fnames = new ArrayList<String>();
    private ArrayList<String> lnames = new ArrayList<String>();

    public Person(String fName, String lName, int age)
    {
        this.fName = fName;
        this.lName = lName;
        this.age = age;

     fnames.add("Aaron");
     fnames.add("Vince");
     fnames.add("Levi");
     fnames.add("Sarah");
     fnames.add("Emily");
     lnames.add("McFarland");
     lnames.add("Maimone");
     lnames.add("Smith");
    }
    public void getInfo()
    {
        System.out.println("First Name: " + this.fName + "Last Name: " + this.lName + " Age: " + this.age);
    }


    public static void main(String[] Args)
    {
      Professor prof = new Professor("Dave", "Smith", 34, "Phd in IST", 68970);
      Student stud = new Student("Joey", "Williams", 20, 914987112, 3.1, "Junior");
      Visitor vis = new Visitor("Vincent", "Maimone", 20);

      prof.getInfo();
//      stud.getInfo()；
//      vis.getInfo()；

    }
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package entities;

import java.util.Random;
*/
/**
 *
 * @author Jon
 */
//
// public abstract class Person {
//
//     /*
//        It makes most sense to give all interactions between students, players,
//         and professors their own class
//     */
//
//     private String personType;
//
//     //common person attributes
//     private int intelligence;
//     private int charisma;
//     private int stress;
//     private int disipline;
//     private int attractiveness;
//     private int luck;
//
//     //Position on the maps
//     private double x;
//     private double y;
//
//     //based on random events, these attributes can be affected
//     //player will get to choose theirs
//     public Person(String personType){
//
//         this.personType = personType;
//
//         Random rand = new Random();
//
//         int intelligence = rand.nextInt(10) + 1;
//         this.intelligence = intelligence;
//
//         int charisma = rand.nextInt(10) + 1;
//         this.charisma = charisma;
//
//         int stress = rand.nextInt(10) + 1;
//         this.stress = stress;
//
//         int disipline = rand.nextInt(10) + 1;
//         this.disipline = disipline;
//
//         int attractiveness = rand.nextInt(10) + 1;
//         this.attractiveness = attractiveness;
//
//         int luck = rand.nextInt(10) + 1;
//         this.luck = luck;
//
//
//
//         //gender under construction
//     }
//
//     public void printAttributes(){
//         System.out.println("Attributes (" + this.personType + ")");
//         System.out.println("---------------------------------");
//         System.out.println("Intelligence: " + intelligence);
//         System.out.println("Charisma: " + charisma);
//         System.out.println("Stress: " + stress);
//         System.out.println("Disipline: " + disipline);
//         System.out.println("Attractiveness: " + attractiveness);
//         System.out.println("Luck: " + luck);
//         System.out.println();
//     }
//
//     //getters
//
//     public int getIntelligence(){
//         return this.intelligence;
//     }
//
//     public int getCharisma(){
//         return this.charisma;
//     }
//
//     public int getStress(){
//         return this.stress;
//     }
//
//     public int getDisipline(){
//         return this.disipline;
//     }
//
//     public int getAttractiveness(){
//         return this.attractiveness;
//     }
//
//     public int getLuck(){
//         return this.luck;
//     }
//
//     //setters
//
//     public void setIntelligence(int intelligence){
//         this.intelligence = intelligence;
//     }
//
//     public void setCharisma(int charisma){
//         this.charisma = charisma;
//     }
//
//     public void setStress(int stress){
//         this.stress = stress;
//     }
//
//     public void setDisipline(int disipline){
//         this.disipline = disipline;
//     }
//
//     public void setAttractiveness(int attractiveness){
//         this.attractiveness = attractiveness;
//     }
//
//     public void setLuck(int luck){
//         this.luck = luck;
//     }
//
// }
