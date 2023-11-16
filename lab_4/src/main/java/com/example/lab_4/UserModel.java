package com.example.lab_4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.*;

public class UserModel {
    public ObservableList<User> readUser() {
        ObservableList<User> users = FXCollections.observableArrayList();
        String file = "D:\\!university\\3sem\\oopip\\labs\\lab_4\\src\\main\\resources\\com\\example\\lab_4\\users.txt";
        BufferedReader br = null;
        String line;
        String splitSym = ",";
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                // Считываем строку из файла и разделяем ее на подстроки по разделителю и заполянем ими массив строк
                String[] data = line.split(splitSym);
                users.add(new User(data[0], data[1], data[2]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return users;
    }

    public void saveUser(User user) {
        // Файл учетных записей
        String file = "D:\\!university\\3sem\\oopip\\labs\\lab_4\\src\\main\\resources\\com\\example\\lab_4\\users.txt";
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.newLine();
            bw.write(user.toString());
            bw.close();
            Alert saveWindow = new Alert(Alert.AlertType.INFORMATION);
            saveWindow.setTitle("Сохранение");
            saveWindow.setContentText("Аккаунт создан");
            saveWindow.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
