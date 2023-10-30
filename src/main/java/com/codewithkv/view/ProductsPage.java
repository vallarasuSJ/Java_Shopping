package com.codewithkv.view;

import com.codewithkv.Utils.FileUtil;
import com.codewithkv.Utils.StringUtil;
import com.codewithkv.Utils.Utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.codewithkv.Utils.FileUtil.getProductsMenu;
import static com.codewithkv.Utils.Utils.print;
import static com.codewithkv.Utils.Utils.println;

public class ProductsPage {
    public void showProducts(){
        println(StringUtil.PRODUCTS_MENU);
        println("---------------------------");
        println(" ");
        println(StringUtil.PRODUCT_DETAILS);
        try {
            Scanner scanner=new Scanner(getProductsMenu());
            while(scanner.hasNext()){
                String[] product=scanner.next().split(",");
                if(!product[0].equals("id")){
                    println(product[0] + " " + product[1] + " " + product[3]);
                }
            }
            println(StringUtil.BACK_OPTION);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void printSuccess() {
        println(StringUtil.SUCCESS_MESSAGE);
    }
}
