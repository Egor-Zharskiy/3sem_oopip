package com.example.lab_4;

public class User {
    private String login;
    private String password;
    private String mumSurname;

    public User(String login, String password, String mumSurname) {
        this.login = login;
        this.password = password;
        this.mumSurname = mumSurname;
    }

    public String getMumSurname() {
        return mumSurname;
    }

    public void setMumSurname(String mumSurname) {
        this.mumSurname = mumSurname;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return login + "," + password + "," + mumSurname;
    }
}
