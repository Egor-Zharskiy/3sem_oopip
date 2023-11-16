package com.example.lab_4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Teacher, String> classes;

    @FXML
    private TableColumn<Teacher, Integer> experience;

    @FXML
    private TableColumn<Teacher, String> name;

    @FXML
    private TableColumn<Teacher, String> subjects;

    @FXML
    private TableView<Teacher> table;

    @FXML
    private TableColumn<Teacher, String> workTime;
    private TeacherModel teacherModel = new TeacherModel();

    private ObservableList<Teacher> teachers = teacherModel.readTeacher();

    @FXML
    void initialize() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        workTime.setCellValueFactory(new PropertyValueFactory<>("workTime"));
        subjects.setCellValueFactory(new PropertyValueFactory<>("subjects"));
        classes.setCellValueFactory(new PropertyValueFactory<>("classes"));
        table.setItems(teachers);

    }

}
