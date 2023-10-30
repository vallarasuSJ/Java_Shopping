package com.codewithkv.controller;

import com.codewithkv.Utils.AppException;
import com.codewithkv.Utils.AppInput;
import com.codewithkv.Utils.StringUtil;
import com.codewithkv.controller.Implementation.IAuthController;
import com.codewithkv.controller.Implementation.IHomeController;
import com.codewithkv.view.HomePage;

import static com.codewithkv.Utils.AppInput.enterInt;
import static com.codewithkv.Utils.UserUtils.setLoggedInUser;
import static com.codewithkv.Utils.Utils.println;

public class HomeController implements IHomeController {
    private final HomePage homePage;

    private final AuthController authController;

    private final CategoryController categoryController;

    private final ProductController productController;

    private final CartController cartController;
    private final OrderController orderController;

    public HomeController(AuthController authController) {
        homePage = new HomePage();
        this.authController = authController;
        categoryController = new CategoryController(this);
        productController = new ProductController(this);
        cartController = new CartController(this);
        orderController = new OrderController(this);
    }

    @Override
    public void printMenu() {
        homePage.printMenu();
        try {
            int choice = enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 1) {
                categoryController.printMenu();

            } else if (choice == 2) {
                productController.showProducts();
            } else if (choice == 3) {
                cartController.showCart();
            } else if (choice == 4) {
                orderController.showOrders();
            } else if (choice == 5) {
                setLoggedInUser(null);
                authController.authMenu();
            }
        } catch (AppException e) {
            throw new RuntimeException(e);
        }

    }
}
