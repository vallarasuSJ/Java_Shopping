package com.codewithkv.view;

import com.codewithkv.Utils.StringUtil;
import static com.codewithkv.Utils.Utils.println;

public class WelcomePage {

    public void welcome() {
        println(StringUtil.WELCOME_MESSAGE);
    }

    public void printAuthMenu() {
        println(StringUtil.AUTH_MENU);
    }
}
