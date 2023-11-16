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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button registration;

    @FXML
    private Button signin;
    private int totalAttempts = 0;
    private boolean isShowed = false;
    private Strategy strategy;
    private UserModel userModel = new UserModel();
    private ObservableList<User> users = userModel.readUser();

    @FXML
    void login() {
        System.out.println(totalAttempts);
        // Проверяем, совпадает ли введенные логин и пароля с существующими
        // Если да, то входим
        // Иначе ошибка
        if (totalAttempts > 2) {
            if (!isShowed) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Смена стратегии");
                alert.setContentText("Вы превысили попытки входа\nВместо пароля введи фамилию мамы");
                alert.showAndWait();
                isShowed = true;
            }
            password_field.setPromptText("фамилия мамы");
            strategy = new SurnameStrategy();
        } else {
            strategy = new PasswordStrategy();
        }
        if (strategy.authenticated(login_field.getText(), password_field.getText(), users)) {
            signin.getScene().getWindow().hide();
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("school_table.fxml"));
            try {
                load.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent pr = load.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Таблица");
            stage.setScene(new Scene(pr));
            stage.show();
        } else {
            totalAttempts += 1;
            Alert authAlert = new Alert(Alert.AlertType.ERROR);
            authAlert.setTitle("Ошибка авторизации");
            authAlert.setContentText("Такие логин и пароль(фамилия) не найдены\nПовторите попытку");
            authAlert.showAndWait();
        }

    }

    @FXML
    void registration() {
        registration.getScene().getWindow().hide();
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("registration.fxml"));
        try {
            load.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent pr = load.getRoot(); // спросить!!!
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Регистация");
        stage.setScene(new Scene(pr));
        stage.show();
    }

    @FXML
    void initialize() {

    }

}
