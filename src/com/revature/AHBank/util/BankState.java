package com.revature.AHBank.util;



import com.revature.AHBank.Screens.LoginScreen;
import com.revature.AHBank.Screens.RegisterScreen;
import com.revature.AHBank.Screens.WelcomeScreen;
import com.revature.AHBank.daos.BankUserDAO;
import com.revature.AHBank.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Encapsulation of application state.
public class BankState {

    private static boolean appRunning;
    private final ScreenRouter router;

    public BankState(){
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BankUserDAO userDAO = new BankUserDAO();
        UserService userService = new UserService(userDAO);
        router.addScreen(new WelcomeScreen(consoleReader,router));
        router.addScreen(new RegisterScreen(consoleReader,router,userService));
        router.addScreen(new LoginScreen(consoleReader, router, userService));

    }


    public void startup(){
        try {
            while (appRunning)
                router.navigate("/welcome");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void shutdown(){
        appRunning = false;

    }
}

