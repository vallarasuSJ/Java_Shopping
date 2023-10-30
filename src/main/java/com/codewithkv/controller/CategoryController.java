package com.codewithkv.controller;

import com.codewithkv.Utils.AppException;
import com.codewithkv.Utils.AppInput;
import com.codewithkv.Utils.FileUtil;
import com.codewithkv.Utils.StringUtil;
import com.codewithkv.controller.Implementation.ICategoryController;
import com.codewithkv.view.CategoryPage;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.codewithkv.Utils.AppInput.enterInt;
import static com.codewithkv.Utils.AppInput.enterString;
import static com.codewithkv.Utils.FileUtil.getCategoryMenu;
import static java.lang.Integer.parseInt;

public class CategoryController implements ICategoryController {
    private final HomeController homeController;
    private  final ProductController productController;

    public CategoryController(HomeController homeController) {
        this.homeController=homeController;
        productController=new ProductController(homeController);

    }

    public void printMenu() {
        CategoryPage.printMenu();

        String choice=enterString(StringUtil.ENTER_CHOICE);
        try {
            Scanner scanner=new Scanner(getCategoryMenu());
            while(scanner.hasNext()){
                String[] value=scanner.next().split(",");
                if(value[0].equals(choice)){
                    productController.showProducts(choice);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
