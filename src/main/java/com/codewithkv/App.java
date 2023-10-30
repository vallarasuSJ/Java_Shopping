package com.codewithkv;


import com.codewithkv.Utils.LoadUtils;
import com.codewithkv.controller.AppController;

public class App {
    public static void main(String[] args) {
        AppController appController=new AppController();
       // LoadUtils.load();
        appController.init();
    }
}