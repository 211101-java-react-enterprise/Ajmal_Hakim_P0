package com.revature.AHBank.daos;
import com.revature.AHBank.models.BankUser;

import com.revature.AHBank.util.List;
import com.revature.AHBank.util.datasource.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BankUserDAO implements CrudDAO<BankUser>{
    public BankUser findUserByUsername(String username) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from bank_accounts where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                BankUser bankUser = new BankUser();
                bankUser.setId(rs.getString("user_id"));
                bankUser.setFirstName(rs.getString("first_name"));
                bankUser.setLastName(rs.getString("last_name"));
                bankUser.setEmail(rs.getString("email"));
                bankUser.setSsn(rs.getString("ssn"));
                bankUser.setUsername(rs.getString("username"));
                bankUser.setPassword(rs.getString("password"));
                return bankUser;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
    public BankUser findUserByEmail(String email) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from bank_accounts where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                BankUser bankUser = new BankUser();
                bankUser.setId(rs.getString("user_id"));
                bankUser.setFirstName(rs.getString("first_name"));
                bankUser.setLastName(rs.getString("last_name"));
                bankUser.setEmail(rs.getString("email"));
                bankUser.setSsn(rs.getString("ssn"));
                bankUser.setUsername(rs.getString("username"));
                bankUser.setPassword(rs.getString("password"));
                return bankUser;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    // TODO: Implement me!
    public BankUser findUserByUsernameAndPassword(String username, String password) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from bank_accounts where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                BankUser bankUser = new BankUser();
                bankUser.setId(rs.getString("user_id"));
                bankUser.setFirstName(rs.getString("first_name"));
                bankUser.setLastName(rs.getString("last_name"));
                bankUser.setEmail(rs.getString("email"));
                bankUser.setSsn(rs.getString("ssn"));
                bankUser.setUsername(rs.getString("username"));
                bankUser.setPassword(rs.getString("password"));
                return bankUser;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public BankUser save(BankUser newUser) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            newUser.setId(UUID.randomUUID().toString());

            String sql = "insert into bank_accounts (user_id, first_name, last_name, email,ssn, username, password) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getId());
            pstmt.setString(2, newUser.getFirstName());
            pstmt.setString(3, newUser.getLastName());
            pstmt.setString(4, newUser.getEmail());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setString(6, newUser.getUsername());
            pstmt.setString(7, newUser.getPassword());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                return newUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
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
