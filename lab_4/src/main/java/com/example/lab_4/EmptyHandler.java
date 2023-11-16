package com.example.lab_4;

import javafx.scene.control.Alert;

public class EmptyHandler implements Handler {
    private Handler handler;

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public boolean handleReg(String login, String password, String passwordConfirm, String mumSurname) {
        if (login.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty() || mumSurname.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка заполнения");
            alert.setContentText("Заполните все поля для ввода");
            alert.showAndWait();
            return false;
        } else if (handler ==  null) return true;
        else {
            return handler.handleReg(login, password, passwordConfirm, mumSurname);
        }
    }
}