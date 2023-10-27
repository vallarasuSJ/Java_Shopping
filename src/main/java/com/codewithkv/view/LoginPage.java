package com.codewithkv.view;

import static com.codewithkv.Utils.Utils.println;

public class LoginPage {
    public void printInvalidCredentials(){

        try {
            println("------Invalid credentials-------");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
