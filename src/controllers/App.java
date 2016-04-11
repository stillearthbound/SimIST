package controllers;

import Sandbox.ManualTwitterUI;
import Sandbox.TwitterCntl;

public class App {

    public static void main(String[] args, TwitterCntl parentTwitterCntl) {
        ManualTwitterUI test = new ManualTwitterUI(parentTwitterCntl);
    }
}
