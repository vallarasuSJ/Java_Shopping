package com.codewithkv.view;

import com.codewithkv.Utils.AppInput;
import com.codewithkv.Utils.FileUtil;
import com.codewithkv.Utils.StringUtil;
import com.codewithkv.Utils.Utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.codewithkv.Utils.FileUtil.getCategoryMenu;
import static com.codewithkv.Utils.Utils.println;

public class CategoryPage {

    public static void printMenu() {

        try {
            println(StringUtil.CATEGORY_MENU);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Scanner scanner=new Scanner(getCategoryMenu());
            while(scanner.hasNext()){
                String[] value=scanner.next().split(",");
                println(value[0]+ " " + value[1]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
