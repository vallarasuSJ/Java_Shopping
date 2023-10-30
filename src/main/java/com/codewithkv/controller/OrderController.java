package com.codewithkv.controller;

import com.codewithkv.Utils.FileUtil;
import com.codewithkv.Utils.Utils;
import com.codewithkv.controller.Implementation.IOrderController;
import com.codewithkv.models.Order;
import com.codewithkv.models.User;
import com.codewithkv.view.OrdersPage;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

import static com.codewithkv.Utils.FileUtil.*;
import static com.codewithkv.Utils.UserUtils.getLoggedInUser;

public class OrderController implements IOrderController {


    private final HomeController homeController;

    public OrderController(HomeController homeController) {
        this.homeController = homeController;

    }


    @Override
    public void checkout() {
        User loggedUser=getLoggedInUser();

        try {

            Scanner scanner = new Scanner(getCartFile());
            while (scanner.hasNext()) {
                FileWriter csvWriter = new FileWriter(getOrder(), true);
                FileWriter tempcart=new FileWriter(getFile(),true);
                String[] cartProduct = scanner.next().split(",");
                if (!cartProduct[0].equals("ID") && cartProduct[1].equals(loggedUser.getEmail())) {
                    csvWriter.append("\n");
                    csvWriter.append(cartProduct[0] + "," + cartProduct[1] + "," + cartProduct[2]);
                    csvWriter.flush();
                    csvWriter.close();
                }
                if(!cartProduct[0].equals("ID") && !cartProduct[1].equals(loggedUser.getEmail())){
                    tempcart.append("\n");
                    tempcart.append(cartProduct[0] + "," + cartProduct[1] + "," + cartProduct[2] + "," +cartProduct[3]);
                    tempcart.flush();
                    tempcart.close();
                    ClearCart();
                }
            }
            homeController.printMenu();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void ClearCart() throws IOException {
        FileInputStream inputStream= new FileInputStream(getFile());
        FileOutputStream outputStream=new FileOutputStream(getCartFile());

        int i;
        while((i=inputStream.read())!=-1){
            outputStream.write(i);
     }
        outputStream.close();
        inputStream.close();
    }

    @Override
    public void showOrders() {
        OrdersPage.printOrder();

    }
}
