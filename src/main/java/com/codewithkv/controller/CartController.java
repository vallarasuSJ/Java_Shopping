package com.codewithkv.controller;

import com.codewithkv.Utils.*;
import com.codewithkv.controller.Implementation.ICartController;
import com.codewithkv.models.Cart;
import com.codewithkv.models.CartProduct;
import com.codewithkv.models.Order;
import com.codewithkv.models.User;
import com.codewithkv.view.CartPage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.codewithkv.Utils.AppInput.enterInt;

import static com.codewithkv.Utils.FileUtil.getCartFile;
import static com.codewithkv.Utils.UserUtils.getLoggedInUser;
import static com.codewithkv.Utils.Utils.println;

public class CartController implements ICartController {

    private HomeController homeController;
    private final CartPage cartPage;
    private  final OrderController orderController;

    public CartController(HomeController homeController) {
        this.homeController = homeController;
        cartPage = new CartPage();
        orderController=new OrderController(homeController);
    }
    public void addToCart(String productChoice) {
        User loggedUser = getLoggedInUser();
        Cart cart = new Cart();
//        try {
//            Scanner scanner = new Scanner(getCart());
//            FileWriter csvWriter = null;
//            while (scanner.hasNext()) {
//                String[] product = scanner.next().split(",");
//
//                if (product[1].equals(loggedUser.getEmail()) && product[0].equals(productChoice)) {
//                    int count = Integer.parseInt(product[3]) + 1;
//                    System.out.println(count);
//                    try {
//                        csvWriter = new FileWriter(getCart(), false);
//                        csvWriter.append("\n");
//                        csvWriter.append(productChoice + "," + loggedUser.getEmail() + "," + product[1] + "," + count);
//                        csvWriter.flush();
//                        csvWriter.close();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//
//
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }


        try {
            Scanner scanner = new Scanner(FileUtil.getProductsMenu());
            int count = 1;
            while (scanner.hasNext()) {
                String[] product = scanner.next().split(",");
                    if (product[0].equals(productChoice)) {
                        try {
                            FileWriter csvWriter = new FileWriter(getCartFile(), true);
                            csvWriter.append("\n");
                            csvWriter.append(productChoice + "," + loggedUser.getEmail() + "," + product[1] + "," + count);
                            csvWriter.flush();
                            csvWriter.close();
                            cart.setId(productChoice);
                            cart.setEmail(loggedUser.getEmail());
                            cart.setProductName(product[1]);
                            cart.setCount(count);

                            System.out.println(cart.getEmail() + " " + cart.getId() + " " + cart.getProductName());
                        }

                        catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }


            } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Override
    public void showCart() {
        cartPage.printCart();

        try {
            int choice=enterInt(StringUtil.ENTER_CHOICE);
            if(choice==88){

                checkout();
            }
        } catch (AppException e) {
            throw new RuntimeException(e);
        }

    }

    private void checkout() {

        orderController.checkout();
    }


}
