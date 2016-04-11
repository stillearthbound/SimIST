package controllers;

import Sandbox.ManualTwitterUI;
import Sandbox.TwitterCntl;

public class App {

    public static void main(String[] args, TwitterCntl parentTwitterCntl) {
//        FrameTester test = new FrameTester();
        ManualTwitterUI test = new ManualTwitterUI(parentTwitterCntl);
    }
}
