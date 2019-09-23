package com.cheatsheet.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerConf {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_conf;

    @FXML
    private Button button_back;

    @FXML
    private Button button_yes;

    public static boolean answ;

    @FXML
    void initialize() {
        label_conf.setText("Удалить вопрос?");
        answ = false;

        button_yes.setOnAction(actionEvent -> {
            button_yes.getScene().getWindow().hide();
            answ = true;
        });
//
        button_back.setOnAction(actionEvent -> {
            button_back.getScene().getWindow().hide();
            answ = false;
        });

        setButtonAnimation();
    }

    private void setButtonAnimation() {
        button_yes.setOnMouseClicked(mouseEvent -> {
            button_yes.setOpacity(1f);
        });

        button_yes.setOnMousePressed(mouseEvent -> {
            button_yes.setOpacity(0.4f);
        });

        button_back.setOnMouseClicked(mouseEvent -> {
            button_back.setOpacity(1f);
        });

        button_back.setOnMousePressed(mouseEvent -> {
            button_back.setOpacity(0.4f);
        });
    }
}
