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

        field_answ.setOnKeyTyped(keyEvent -> {
            button_ok.setDisable(field_answ.getText().isEmpty());
        });

        field_answ.setOnAction(actionEvent -> {
            button_ok.setDisable(field_answ.getText().isEmpty());
        });

        button_ok.setOnAction(actionEvent -> {
            /**
             * добавляем в репозиторий ответ на вопрос
             **/

            button_ok.getScene().getWindow().hide();
        });

        button_back.setOnAction(actionEvent -> {
            button_back.getScene().getWindow().hide();
        });

        setButtonAnimation();
    }

    private void setButtonAnimation() {
        button_ok.setOnMouseClicked(mouseEvent -> {
            button_ok.setOpacity(1f);
        });

        button_ok.setOnMousePressed(mouseEvent -> {
            button_ok.setOpacity(0.4f);
        });

        button_back.setOnMouseClicked(mouseEvent -> {
            button_back.setOpacity(1f);
        });

        button_back.setOnMousePressed(mouseEvent -> {
            button_back.setOpacity(0.4f);
        });
    }
}