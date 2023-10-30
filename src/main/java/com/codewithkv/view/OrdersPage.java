package com.codewithkv.view;

import com.codewithkv.Utils.StringUtil;
import com.codewithkv.Utils.Utils;
import com.codewithkv.controller.HomeController;
import com.codewithkv.controller.OrderController;
import com.codewithkv.models.User;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.codewithkv.Utils.FileUtil.getOrder;
import static com.codewithkv.Utils.UserUtils.getLoggedInUser;
import static com.codewithkv.Utils.Utils.print;
import static com.codewithkv.Utils.Utils.println;

public class OrdersPage {

    public static void printOrder() {
        println(StringUtil.ORDER_MESSAGE);
        println(StringUtil.ORDER_PAGE);
        Scanner scanner= null;
        User loggedUser=getLoggedInUser();
        try {
            scanner = new Scanner(getOrder());
            while(scanner.hasNext()){
                String[] order=scanner.next().split(",");
                if(order[1].equals(loggedUser.getEmail())){
                    println(order[0] + " " + order[2]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
