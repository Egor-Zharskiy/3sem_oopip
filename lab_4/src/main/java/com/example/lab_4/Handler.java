package com.example.lab_4;

public interface Handler {
    void setNextHandler(Handler handler);
    boolean handleReg(String login, String password, String passwordConfirm, String mumSurname);
}
