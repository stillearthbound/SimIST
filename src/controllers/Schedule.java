///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controllers;
//import org.jsoup.nodes.*;
//import org.jsoup.parser.*;
//import org.jsoup.select.Elements;
//import java.io.*;
//import org.jsoup.Jsoup;
///**
// *
// * @author Colin
// */
//public class Schedule {
//    
//    public Schedule(){
//        
//    }
//    
//    public void parseScheduleDocument(){
//        File inputSchedule = new File("src/controllers/ISTschedule.htm");
//        try {
//            Document html = Jsoup.parse(inputSchedule, "UTF-8");
//            Elements allCourses = html.body().getElementsByClass("course_abbrev");
//            String test = allCourses.text();
//            System.out.print(test);
//            
//            Elements moreInfo = html.body().getElementsByClass("course_description");
//            String test2 = moreInfo.text();
//            System.out.printf(test2);
//        }catch (IOException e){
//            System.out.printf("Fail");
//        }
//        
//    }
//}
