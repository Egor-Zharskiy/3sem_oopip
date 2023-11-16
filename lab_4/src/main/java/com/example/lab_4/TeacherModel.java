package com.example.lab_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TeacherModel {
    public ObservableList<Teacher> readTeacher() {
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        String file = "D:\\!university\\3sem\\oopip\\labs\\lab_4\\src\\main\\resources\\com\\example\\lab_4\\table.txt";
        BufferedReader br = null;
        String line;
        String splitSym = ",";
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                // Считываем строку из файла и разделяем ее на подстроки по разделителю и заполянем ими массив строк
                String[] data = line.split(splitSym);
                teachers.add(new Teacher(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4]));

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

        return teachers;

    }
}
