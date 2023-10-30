package com.codewithkv.view;

import com.codewithkv.Utils.FileUtil;
import com.codewithkv.Utils.StringUtil;
import com.codewithkv.Utils.Utils;
import com.codewithkv.controller.CartController;
import com.codewithkv.controller.OrderController;
import com.codewithkv.models.Cart;
import com.codewithkv.models.User;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.codewithkv.Utils.FileUtil.getCartFile;
import static com.codewithkv.Utils.UserUtils.getLoggedInUser;
import static com.codewithkv.Utils.Utils.println;

public class CartPage {
    public void printCart() {
        println(StringUtil.CART_MESSAGE);
        println(StringUtil.CART_MENU);
        try {
            User loggedUser=getLoggedInUser();
            Scanner scanner=new Scanner(getCartFile());
            while (scanner.hasNext()){
                String[] cartProduct=scanner.next().split(",");
                if(cartProduct[1].equals(loggedUser.getEmail())){
                    println(cartProduct[0] + " " + cartProduct[1] + " " + cartProduct[2] + " " + cartProduct[3]);

                }

            }
            println(StringUtil.CHECK_OUT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void checkout(){
        println(StringUtil.CHECK_OUT);
    }
}
