package com.revature.AHBank.Screens;

import com.revature.AHBank.util.BankState;
import com.revature.AHBank.util.ScreenRouter;

import java.io.BufferedReader;



public class WelcomeScreen extends Screen {

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
    }

    @Override
    public void render() throws Exception {

        System.out.println("Welcome to AH Bank: PLease select from following options\n"
                +"1) Login\n"
                +"2) Create Account\n"
                +"3) Deposit\n"
                +"4  Withdraw\n"
                +"5) View your current balance\n"
                +"6) exit");

        String userInput = consoleReader.readLine();

        switch (userInput){
            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                System.out.println("You select Deposit"); break;
            case "4":
                System.out.println("You select withdraw"); break;
            case "5":
                System.out.println("You select "); break;
            case "6":
                System.out.println("You select exit");
                System.out.println("Terminating ...");
                BankState.shutdown();
                break;
            default:
                System.out.println("Invalid choice: Please try again ");
        }

    }
}