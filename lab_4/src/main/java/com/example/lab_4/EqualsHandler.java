package com.example.lab_4;

import javafx.scene.control.Alert;

public class EqualsHandler implements Handler {
    private Handler handler;

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public boolean handleReg(String login, String password, String passwordConfirm, String mumSurname) {
        if (!password.equals(passwordConfirm)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка совпадения");
            alert.setContentText("Пароли не совпадают");
            alert.showAndWait();
            return false;
        } else if (handler ==  null) return true;
        else {
            return handler.handleReg(login, password, passwordConfirm, mumSurname);
        }
    }
}
