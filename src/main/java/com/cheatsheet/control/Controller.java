package com.cheatsheet.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField field_search;

    /** кнопки **/
    @FXML
    private Button button_edit;
    @FXML
    private Button button_delete;
    @FXML
    private Button button_add;

    @FXML
    private ScrollPane scroll_panel;

    public static String question;

    @FXML
    void initialize() {
        field_search.setOnAction(actionEvent -> {
            question = field_search.getText();

            /**
             * ищем из бд ответ на вопрос
             * **/

            if (field_search.getText().equals("кдвц")) { // если нашли такой вопрос
                field_search.setLayoutY(5);

                setActive_buttons_edit(true);
                setActive_button_add(false);
                setActive_scrollPanel(true);
            } else if (field_search.getLength() > 0) { // если не нашли такого вопроса
                field_search.setLayoutY(162);

                setActive_buttons_edit(false);
                setActive_button_add(true);
                setActive_scrollPanel(false);
            } else {
                field_search.setLayoutY(162);

                setActive_buttons_edit(false);
                setActive_button_add(false);
                setActive_scrollPanel(false);
            }
        });

        button_add.setOnAction(actionEvent -> {
            /** добавляем вопрос в репозиторий и отправляемся в меню редактирования вопроса **/
            button_add.getScene().getWindow().hide();

            /**
             * сначала добавляем вопрос в репозиторий
             */

            openEditMenu();
        });

        button_edit.setOnAction(actionEvent -> {
            /** просто отправляемся меню редактирования вопроса **/
            button_edit.getScene().getWindow().hide();

            openEditMenu();
        });
    }

    private void openEditMenu() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/EditMenu.fxml"));

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

    private void setActive_buttons_edit(boolean flag) {
        button_delete.setVisible(flag);
        button_delete.setDisable(!flag);

        button_edit.setVisible(flag);
        button_edit.setDisable(!flag);
    }

    private void setActive_button_add(boolean flag) {
        button_add.setVisible(flag);
        button_add.setDisable(!flag);
    }

    private void setActive_scrollPanel(boolean flag) {
        scroll_panel.setVisible(flag);
        scroll_panel.setDisable(!flag);
    }
}