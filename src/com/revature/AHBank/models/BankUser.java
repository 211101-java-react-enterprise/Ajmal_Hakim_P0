package com.revature.AHBank.models;

import java.util.Objects;

public class BankUser {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String ssn;
    private String username;
    private String password;

    public BankUser(String firstName, String lastName, String email, String ssn, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ssn=ssn;
        this.username = username;
        this.password = password;

    }
    public BankUser(String id, String firstName, String lastName, String email,String ssn, String username, String password) {
        this(firstName, lastName, email,ssn, username, password);
        this.id = id;
    }
    public BankUser(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "BankUser{" +
                "ID = " + id +'\''+
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String toFileString() {
        StringBuilder builder = new StringBuilder();
        builder.append(id).append(":")
                .append(firstName).append(":")
                .append(lastName).append(":")
                .append(email).append(":")
                .append(ssn).append(":")
                .append(username).append(":")
                .append(password);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankUser bankUser = (BankUser) o;
        return Objects.equals(id, bankUser.id) && Objects.equals(firstName, bankUser.firstName) && Objects.equals(lastName, bankUser.lastName) && Objects.equals(email, bankUser.email)&& Objects.equals(ssn, bankUser.ssn) && Objects.equals(username, bankUser.username) && Objects.equals(password, bankUser.password);
    }

    public String fileFormat(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id).append(":")
                .append(firstName).append(":")
                .append(lastName).append(":")
                .append(email).append(":")
                .append(ssn).append(":")
                .append(username).append(":")
                .append(password);
        return stringBuilder.toString();

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email,ssn, username, password);
    }
}
