package com.revature.AHBank.Screens;

import com.revature.AHBank.models.BankUser;
import com.revature.AHBank.services.UserService;
import com.revature.AHBank.util.ScreenRouter;

import java.io.BufferedReader;

public class DashboardScreen extends Screen {

    private final UserService userService;

    public DashboardScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("DashboardScreen", "/dashboard", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

        BankUser bankUser = userService.getBankUser();
        if (bankUser == null) {
            System.out.println("You are not logged in! Navigating back to Login Screen...");
            router.navigate("login");
            return;
        }

        while (userService.isSessionActive()) {
            System.out.printf("\n%s's Dashboard\n", bankUser.getFirstName());

            String menu = "1) View Account Balance\n" +
                    "2) Deposit money\n" +
                    "3) Withdraw money\n" +
                    "4) Logout\n" +
                    "Enter choice here > ";

            System.out.print(menu);

            String bankUserSelection = consoleReader.readLine();

            switch (bankUserSelection) {
                case "1":
                    router.navigate("/balance");
                    break;
                case "2":
                    router.navigate("/deposits");
                    break;
                case "3":
                    router.navigate("/withdrawals");
                    break;
                case "4":
                    userService.logout();
                    break;
                default:
                    System.out.println("Invalid choice .");
            }
        }
    }
}