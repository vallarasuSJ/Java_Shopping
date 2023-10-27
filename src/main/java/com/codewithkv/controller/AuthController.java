package com.codewithkv.controller;

import com.codewithkv.Utils.*;
import com.codewithkv.controller.Implementation.IAuthController;
import com.codewithkv.controller.Implementation.IHomeController;
import com.codewithkv.models.Role;
import com.codewithkv.models.User;
import com.codewithkv.view.LoginPage;
import com.codewithkv.view.RegisterPage;
import com.codewithkv.view.WelcomePage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.codewithkv.Utils.AppInput.enterInt;
import static com.codewithkv.Utils.AppInput.enterString;
import static com.codewithkv.Utils.FileUtil.getCredentialsFile;
import static com.codewithkv.Utils.Utils.println;


public class AuthController implements IAuthController {

    private final HomeController homeController;

    private final AppController appController;

    private final LoginPage loginPage;

    private final RegisterPage registerPage;


    public AuthController(AppController appController) {
        this.appController = appController;
        homeController = new HomeController();

        loginPage = new LoginPage();

        registerPage = new RegisterPage();
    }


    @Override
    public void authMenu() {
        appController.printAuthMenu();
        int choice;
        try {
            choice = enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else {
                invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }


    }

    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        authMenu();
    }

    @Override
    public void login() {
        String email, password;
        email = enterString(StringUtil.ENTER_EMAIL);
        password = enterString(StringUtil.ENTER_PASSWORD);
        User user = validateUser(email, password);
        if (user != null) {
            homeController.printMenu();
        } else {
            loginPage.printInvalidCredentials();
            authMenu();
        }


    }

    private User validateUser(String email, String password) {
        try {
            Scanner scanner = new Scanner(getCredentialsFile());
            while (scanner.hasNext())
            {
                String[] value = scanner.next().split(",");
                if(!value[0].equals("id"))
                {
                    if(value[2].equals(email) && value[3].equals(password)){
                        User user=new User();
                        user.setId(Integer.parseInt(value[0]));
                        user.setName(value[1]);
                        user.setEmail(value[2]);
                        user.getPassword(value[3]);
                        if(user.getEmail().equals("admin@gmail.com")){
                            user.setRole(Role.ADMIN);
                        }
                        else{
                            user.setRole(Role.USER);
                        }
                        return user;

                    }



                }
                System.out.println(value);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        User user = new User();

        return user;
    }

    @Override
    public void register() {
        String email, password, name, confirmPassword;
        name = enterString(StringUtil.ENTER_NAME);
        email = enterString(StringUtil.ENTER_EMAIL);
        password = enterString(StringUtil.ENTER_PASSWORD);
        confirmPassword = enterString(StringUtil.ENTER_PASSWORD_AGAIN);

        if (password.equals(confirmPassword)) {
            FileWriter csvWriter = null;
            try {
                csvWriter = new FileWriter(getCredentialsFile(), true);
                int id = (int) (Math.random() * 100);
                csvWriter.append("\n");
                csvWriter.append(id + "," + name + "," + email + "," + password);
                csvWriter.flush();
                csvWriter.close();
                registerPage.printRegistrationSuccessful();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            registerPage.passwordMismatch();
        }
        authMenu();
    }

    @Override
    public void logout() {

    }

}
