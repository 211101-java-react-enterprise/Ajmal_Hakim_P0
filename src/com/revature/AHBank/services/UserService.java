package com.revature.AHBank.services;

import com.revature.AHBank.daos.BankUserDAO;
import com.revature.AHBank.exceptions.AuthenticationException;
import com.revature.AHBank.exceptions.InvalidRequestException;
import com.revature.AHBank.exceptions.ResourcePersistenceException;
import com.revature.AHBank.models.BankUser;
import com.revature.AHBank.util.BankState;

import java.io.File;
import java.io.FileWriter;

public class UserService {
    private  BankUserDAO userDAO;
    private BankUser bankUser;

    public UserService(BankUserDAO userDAO) {
        this.userDAO = userDAO;
        this.bankUser = null;
    }
    public BankUser getBankUser()
    {return bankUser;
    }

    public boolean  registerNewUser(BankUser newUser){
        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        boolean usernameAvailable = userDAO.findUserByUsername(newUser.getUsername()) == null;
        boolean emailAvailable = userDAO.findUserByEmail(newUser.getEmail()) == null;

        if (!usernameAvailable || !emailAvailable) {
            if (!usernameAvailable && emailAvailable) {
                throw new ResourcePersistenceException("The provided username was already taken in the datasource!");
            } else if (usernameAvailable) {
                throw new ResourcePersistenceException("The provided email was already taken in the datasource!");
            } else {
                throw new ResourcePersistenceException("The provided username and email was already taken in the datasource!");
            }
        }
            String msg = "The values provided for the following fields are already taken by other users:";
            if (!usernameAvailable) msg = msg + "\n\t- username";
            if (!emailAvailable) msg = msg + "\n\t- email";
            throw new ResourcePersistenceException(msg);
        }




    public void   authenticateUser(String username, String password){
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provided!");
        }

        BankUser authenticatedUser = userDAO.findUserByUsernameAndPassword(username, password);

        if (authenticatedUser == null) {
            throw new AuthenticationException();
        }

        bankUser = authenticatedUser;

    }

    public void logout() {
        bankUser = null;
    }

    public boolean isSessionActive() {
        return bankUser != null;
    }

    public boolean isUserValid(BankUser user){
        if(user == null) return false;
        if(user.getFirstName()== null || user.getFirstName().equals("")) return false;
        if(user.getLastName()== null || user.getLastName().equals("")) return false;
        if(user.getEmail()== null || user.getEmail().equals("")) return false;
        if(user.getSsn()== null || user.getSsn().equals("")) return false;
        if(user.getUsername()== null || user.getUsername().equals("")) return false;
        return (user.getPassword() != null && user.getPassword().equals(""));


    }


}
