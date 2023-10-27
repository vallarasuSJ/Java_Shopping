package com.codewithkv.controller;

import com.codewithkv.controller.Implementation.IAuthController;
import com.codewithkv.controller.Implementation.IHomeController;

import static com.codewithkv.Utils.Utils.println;

public class HomeController implements IHomeController {



    @Override
    public void printMenu() {
        println("Home controller menu");
    }
}
