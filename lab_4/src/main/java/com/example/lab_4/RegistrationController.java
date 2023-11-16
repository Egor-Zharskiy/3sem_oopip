package com.example.lab_4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML
    private Button back;

    @FXML
    private TextField login_field;

    @FXML
    private TextField mums_surname_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button registration;

    @FXML
    private PasswordField repeat_password;
    private Handler handler;
    private UserModel userModel = new UserModel();
    private ObservableList<User> users = userModel.readUser();

    @FXML
    void prevWindow() {
        back.getScene().getWindow().hide();
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("auth.fxml"));
        try {
            load.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent pr = load.getRoot();
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Авторизация");
        stage.setScene(new Scene(pr));
        stage.show();
    }

    @FXML
    void registration() {
        if(handler.handleReg(login_field.getText(), password_field.getText(), repeat_password.getText() ,mums_surname_field.getText())) {
            User user = new User(login_field.getText(), password_field.getText(), mums_surname_field.getText());
            userModel.saveUser(user);
            login_field.clear();
            password_field.clear();
            mums_surname_field.clear();
            repeat_password.clear();
        }
    }

    @FXML
    void initialize() {
        EmptyHandler emptyHandler = new EmptyHandler();
        ExistsHandler existsHandler = new ExistsHandler();
        EqualsHandler equalsHandler = new EqualsHandler();

        emptyHandler.setNextHandler(equalsHandler);
        equalsHandler.setNextHandler(existsHandler);
        handler = emptyHandler;
    }

}
