/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author amm6946
 */
public class Visitor extends Person
{
    private int collegeAffinity;
    
    public Visitor(String fName, String lName, int age)
    {
        super(fName, lName, age);
        collegeAffinity = 0;
    }
    
//    public String getInfo()
//    {
//       return super.getInfo();
//        
//    }
}
