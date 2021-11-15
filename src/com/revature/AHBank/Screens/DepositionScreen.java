package com.revature.AHBank.Screens;

import com.revature.AHBank.services.UserService;
import com.revature.AHBank.util.ScreenRouter;

import java.io.BufferedReader;
import static com.revature.AHBank.Screens.CurrentBalanceScreen.balance;

public class DepositionScreen extends Screen {

    private final UserService userService;

    public DepositionScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("DepositonScreen", "/depsition", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        double depositAmount;



    }
}
