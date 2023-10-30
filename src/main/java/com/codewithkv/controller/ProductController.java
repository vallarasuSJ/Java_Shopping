package com.codewithkv.controller;

import com.codewithkv.Utils.AppInput;
import com.codewithkv.Utils.FileUtil;
import com.codewithkv.Utils.StringUtil;
import com.codewithkv.Utils.Utils;
import com.codewithkv.controller.Implementation.ICartController;
import com.codewithkv.controller.Implementation.IProductController;
import com.codewithkv.view.ProductsPage;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.codewithkv.Utils.AppInput.enterString;
import static com.codewithkv.Utils.FileUtil.getProductsMenu;
import static com.codewithkv.Utils.Utils.print;
import static com.codewithkv.Utils.Utils.println;

public class ProductController implements IProductController {
    private final HomeController homeController;
    private final ProductsPage productsPage;
    private final CartController cartController;

    public ProductController(HomeController homeController) {
        this.homeController=homeController;
        productsPage = new ProductsPage();
        cartController=new CartController(homeController);
    }

    @Override
    public void showProducts() {
        productsPage.showProducts();
        try {
            Scanner scanner=new Scanner(getProductsMenu());
            String productChoice= enterString(StringUtil.ENTER_CHOICE);
            while (scanner.hasNext()){
                String[] product=scanner.next().split(",");
                if(product[0].equals(productChoice)){
                    cartController.addToCart(productChoice);
                    productsPage.printSuccess();
                    showProducts();
                }
            }
            if(productChoice.equals("99")){
                homeController.printMenu();
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void showProducts(String choice) {
        println(StringUtil.PRODUCTS_MENU);
        println(StringUtil.PRODUCT_DETAILS);
        try {
            Scanner scanner=new Scanner(getProductsMenu());
            while(scanner.hasNext()){
                String[] product=scanner.next().split(",");
                if(product[6].equals(choice)){
                    println(product[0] + " " + product[1] + " " + product[3]);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Scanner scanner=new Scanner(getProductsMenu());
            String productChoice= enterString(StringUtil.ENTER_CHOICE);
           System.out.println(productChoice);
            if(productChoice=="99"){
                homeController.printMenu();
            }
            while (scanner.hasNext()){
                String[] product=scanner.next().split(",");
                if(product[0].equals(productChoice)){
                    cartController.addToCart(productChoice);
                    productsPage.printSuccess();
                    showProducts(choice);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}




