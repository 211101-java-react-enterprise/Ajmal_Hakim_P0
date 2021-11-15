package com.revature.AHBank.Screens;
import com.revature.AHBank.models.BankUser;
import com.revature.AHBank.services.UserService;
import com.revature.AHBank.util.ScreenRouter;

import java.io.BufferedReader;



public class RegisterScreen extends Screen {
    private final UserService userService;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService){
        super("RegisterScreen","/register",consoleReader,router);
        this.userService=userService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("The user selected to register");
        System.out.println("Please provide the following information:");
        System.out.print("First Name: ");
        String firstName = consoleReader.readLine();
        System.out.print("Last Name: ");
        String lastName =consoleReader.readLine() ;
        System.out.print("Email address: ");
        String email = consoleReader.readLine();
        System.out.print("ssn: ");
        String ssn = consoleReader.readLine();
        System.out.print(" username: ");
        String username = consoleReader.readLine();
        System.out.print("Password: ");
        String password = consoleReader.readLine();

        System.out.printf("User provided info: { \"First Name\": %s,\"last Name\": %s,\"Email address\": %s}\n",firstName,lastName,email);

        BankUser newUser = new BankUser(firstName,lastName,email,ssn,username,password);

       boolean registerSuccessful = userService.registerNewUser(newUser);

       if(registerSuccessful){
           router.navigate("/dashboard");
       } else {
           System.out.println("You have provided invalid data. Please try again.");
       }

    }
}

