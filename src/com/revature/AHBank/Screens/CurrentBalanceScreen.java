package com.revature.AHBank.Screens;



import com.revature.AHBank.services.UserService;
import com.revature.AHBank.util.ScreenRouter;

import java.io.BufferedReader;

public class CurrentBalanceScreen extends Screen {

    public static double balance = 0.00;
    private final UserService userService;

    public CurrentBalanceScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("CurrentBalanceScreen", "/balance", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

    }
}