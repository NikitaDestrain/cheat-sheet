package com.cheatsheet.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerEdit {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label heading;

    @FXML
    private ScrollPane scroll_panel;

    @FXML
    private Button button_add;

    @FXML
    void initialize() {
        heading.setText(Controller.question + "?");

        button_add.setOnAction(actionEvent -> {
            /** переходим в меню добавления нового ответа **/
            button_add.getScene().getWindow().hide();
            openAddMenu();
        });
    }

    private void openAddMenu() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/AddMenu.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
