/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author vqm5108
 */
public class Professor extends Person
{
    private String degree;
    private int salary;

    public Professor(String fName, String lName, int age, String degree, int salary)
    {
        super(fName, lName, age);
        this.degree = degree;
        this.salary = salary;
    }

//    public String getInfo()
//    {
//        return super.getInfo();
//    }

}
