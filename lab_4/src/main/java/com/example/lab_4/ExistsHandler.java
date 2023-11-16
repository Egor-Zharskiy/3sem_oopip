package com.example.lab_4;

import javafx.scene.control.Alert;

import java.util.List;

public class ExistsHandler implements Handler{
    private Handler handler;
    private UserModel userModel = new UserModel();

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public boolean handleReg(String login, String password, String passwordConfirm, String mumSurname) {
        if(userExists(login)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка наличия");
            alert.setContentText("Пользователь с таким логином уже существует");
            alert.showAndWait();
            return false;
        } else if (handler ==  null) return true;
        else {
            return handler.handleReg(login, password, passwordConfirm, mumSurname);
        }
    }

    private boolean userExists(String login){
        List<User> users = userModel.readUser();
        for(User user: users){
            if(user.getLogin().equals(login)) return true;
        }
        return false;
    }
}
