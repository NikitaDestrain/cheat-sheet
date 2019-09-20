package com.cheatsheet.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdd {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_ok;

    @FXML
    private Button button_back;

    @FXML
    private Label heading;

    @FXML
    private TextField field_answ;

    @FXML
    void initialize() {
        heading.setText(Controller.question + "?");
    }
}