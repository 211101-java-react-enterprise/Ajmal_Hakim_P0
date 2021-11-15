package com.revature.AHBank.Screens;
import com.revature.AHBank.services.UserService;
import com.revature.AHBank.util.ScreenRouter;

import java.io.BufferedReader;
import static com.revature.AHBank.Screens.CurrentBalanceScreen.balance;
public class WithdrawScreen  extends Screen{
    private final UserService userService;

    public WithdrawScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {

        super("WithdrawScreen", "/withdrawals", consoleReader, router);
        this.userService = userService;
    }




    @Override
    public void render() throws Exception {
        try {
            double withdrawAmount;
            System.out.println("Hello! Your current balance is " + "$" + balance + ".");
            System.out.println(" ");
            System.out.print("How much money would you like to withdraw today?\n" +
                    "Enter an amount here > ");
            withdrawAmount = Double.parseDouble(consoleReader.readLine());
            if (withdrawAmount >= 0.00 && balance > withdrawAmount) {
                System.out.println("You have withdrawn " + "$" + withdrawAmount + " from your account!");
                System.out.println(" ");
                balance = balance - withdrawAmount;
                System.out.println("Your new balance is: " + "$" + balance);
                System.out.println(" ");
                System.out.println("Taking you back to dashboard...");
            } else if (balance < withdrawAmount) {
                System.out.println("Cannot withdraw; insufficient funds. Please try again.");
                System.out.println(" ");
                router.navigate("/withdrawals");
            }
        } catch (NumberFormatException n) {
            System.out.println("Invalid command. Please try again.");
            System.out.println(" ");
            router.navigate("/withdrawals");
        }

    }
}
