package com.codewithkv.view;

import com.codewithkv.Utils.StringUtil;

import static com.codewithkv.Utils.Utils.println;

public class LoginPage {
    public void printInvalidCredentials(){

        try {
            println(StringUtil.INVALID_CREDENTIALS);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
