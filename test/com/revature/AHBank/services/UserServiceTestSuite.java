package com.revature.AHBank.services;

import com.revature.AHBank.daos.BankUserDAO;
import com.revature.AHBank.models.BankUser;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTestSuite {
    UserService sut;
    BankUserDAO mockUserDAO;
    @Test
    public void test_isUserValid_returnTrue_givenValidUser(){
        //AAA
        //Arrange
         sut = new UserService(mockUserDAO);
       // BankUser validUser = new BankUser("Arman","Samim","arman.samim@revature.com","122-44-9890","AS15","Sam2021");
        BankUser invalidUser_1 = new BankUser(null, "valid", "valid", "valid", "valid", "valid", "valid");
        BankUser invalidUser_2 = new BankUser("", "valid", "valid", "valid", "valid","valid","valid");
        BankUser invalidUser_3 = new BankUser("             ", "valid", "valid", "valid", "valid", "valid");

        //Act
       // boolean actualResult = sut.isUserValid(validUser);
        boolean actualResult_1 = sut.isUserValid(invalidUser_1);
        boolean actualResult_2 = sut.isUserValid(invalidUser_2);
        boolean actualResult_3 = sut.isUserValid(invalidUser_3);

        //Assert
       // Assert.assertTrue("Expected user to be considered valid",actualResult);
        Assert.assertFalse("Expected user to be considered false.", actualResult_1);
        Assert.assertFalse("Expected user to be considered false.", actualResult_2);
        Assert.assertFalse("Expected user to be considered false.", actualResult_3);
    }


}
