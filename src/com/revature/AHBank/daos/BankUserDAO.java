package com.revature.AHBank.daos;
import com.revature.AHBank.models.BankUser;

import com.revature.AHBank.util.List;

import java.io.*;
import java.util.UUID;

public class BankUserDAO implements CrudDAO<BankUser>{


    // TODO: Implement me!
    public BankUser findUserByUsernameAndPassword(String username, String password) {

        try (BufferedReader dataReader = new BufferedReader(new FileReader("resources/bankfile.txt"))) {

            String dataCursor;
            while((dataCursor = dataReader.readLine()) != null) {
                String[] userData = dataCursor.split(":");
                if (userData[4].equals(username) && userData[5].equals(password)) {
                    return new BankUser(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public BankUser save(BankUser newUser) {

        File usersFile = new File("resources/file.txt");

        // try-with-resources (allows for the instantiation of AutoCloseable types that are implicitly
        // closed when the try logic is finished)
        try (FileWriter fileWriter = new FileWriter(usersFile, true)) {

            // Universally Unique IDentifier (UUID)
            String uuid = UUID.randomUUID().toString();
            newUser.setId(uuid);
            System.out.println("[DEBUG] - AppUser#toString: " + newUser);
            System.out.println("[DEBUG] - AppUser#toFileString: " + newUser. toFileString());
            fileWriter.write(newUser.toFileString() + "\n");

        } catch (Exception e) {
            e.printStackTrace(); // leave for debugging purposes (preferably, write it to a file) - definitely remove before "production"
            throw new RuntimeException("Error persisting user to file.");
        }

        return newUser;
    }

    @Override
    public List<BankUser> findAll() {
        return null;
    }

    @Override
    public BankUser findById(String id) {
        return null;
    }

    @Override
    public boolean update(BankUser updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

}
