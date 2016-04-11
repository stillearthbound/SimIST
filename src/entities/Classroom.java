/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.*;

/**
 *
 * @author junggue, ed reinoso
 */
public class Classroom extends JPanel{

    private class Tool extends Rectangle {}

    private class Computer extends Tool {}

    private class Desk extends Tool {}

    private class Person {
        int location;
    }

    // Function of this class: this is a time table of a class
    // How it works: class room cosists of two arrays that have 24 indexes
    // One for String that includes
    private class AvailabilitySchedule {

        boolean[] availability;
        String[] ActivityList;

        AvailabilitySchedule() {

            availability = new boolean[24];
            ActivityList = new String[24];

            for (int i = 0; i < availability.length; i++) {
                availability[i] = false;
            }

        }

        // schedule   13 ~ 14 
        public void scheduleClass(String className, int startTime, int endTime) {
            for (int i = startTime; i <= endTime; i++) {
                availability[i] = true;
                ActivityList[i] = className;
            }
        }
    }

    //attributes
    private Tool printer;
    private Computer[] computers;
    private Desk[] desks;

    private int maximumPopulation;
    private int currentPopulation;

    private AvailabilitySchedule theClassAvailability;

    private int classRoomNumber;

    //constructor
    public Classroom(int width, int height) {
        
        setPreferredSize(new Dimension(width, height));
        initComponents();
    }

    public void initComponents() {
        
    }

    //classroom behaviors
    public void havingExam() {
    }

    public void havingClass() {
    }

    public void cleaned() {
    }
    //********************************************************************************

    // instructors behaviors
    public void instructorProctoring() {
    }

    public void instructorLecturing() {
    }

    public void instructorExit() {
        currentPopulation--;
    }

    public void instructorComeIn() {
        if (currentPopulation < maximumPopulation) {
            currentPopulation++;
        }
    }
    //********************************************************************************

    // students behaviors
    public void studentSitting() {
    }

    public void studentPresenting() {
    }

    public void studentExit() {
        currentPopulation--;
    }

    public void studentComeIn() {
        if (currentPopulation < maximumPopulation) {
            currentPopulation++;
        }
    }
    //********************************************************************************

    // cleaners behaviors
    public void cleanerClean() {
    }

    public void cleanerExit() {
        currentPopulation--;
    }

    public void cleanerComeIn() {
        if (currentPopulation < maximumPopulation) {
            currentPopulation++;
        }
    }
    //********************************************************************************

}
