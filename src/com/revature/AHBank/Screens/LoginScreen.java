package com.revature.AHBank.Screens;

import com.revature.AHBank.models.BankUser;
import com.revature.AHBank.services.UserService;

import java.io.BufferedReader;
import com.revature.AHBank.util.ScreenRouter;
import com.revature.AHBank.exceptions.AuthenticationException;
import com.revature.AHBank.exceptions.InvalidRequestException;

public class LoginScreen extends Screen {

    private final UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("Please provide your credentials to log into your account.");
        System.out.print("Username > ");
        String username = consoleReader.readLine();
        System.out.print("Password > ");
        String password = consoleReader.readLine();

        try {
           userService.authenticateUser(username, password);
            router.navigate("/dashboard");
        } catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("Incorrect credentials provided! No matching user account found.");
        }

    }
}
