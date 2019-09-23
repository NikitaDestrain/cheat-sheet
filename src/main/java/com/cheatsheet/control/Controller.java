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

public class Controller {
    private final int POS_CENTER_SEARCH_FIELD_Y = 162;
    private final int POS_TOP_SEARCH_FIELD_Y = 5;

    @FXML
    private TextField field_search;

    @FXML
    private Button button_addAnsw;

    @FXML
    private Button button_deleteQ;

    @FXML
    private Button button_addQ;

    @FXML
    private ScrollPane scroll_panel;

    public static String question;


    @FXML
    void initialize() {
        field_search.setOnKeyTyped(keyEvent -> {
            question = field_search.getText();

            /**
             * ищем из бд ответ на вопрос
             **/

            if (field_search.getText().equals("кдвц")) { // если нашли такой вопрос
                setView(1);
            } else if (field_search.getLength() > 0) { // если не нашли такой вопрос
                setView(2);
            } else {
                setView(0);
            }
        });

        button_addQ.setOnAction(actionEvent -> {
            /** добавляем вопрос в репозиторий и отправляемся в меню редактирования вопроса **/

            /**
             * сначала добавляем вопрос в репозиторий
             */

            setView(1);
        });

        button_addAnsw.setOnAction(actionEvent -> {
            /** добавляем вопрос в репозиторий и отправляемся в меню редактирования вопроса **/

            try {
                open_menu("Add");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        button_deleteQ.setOnAction(actionEvent -> {
            /** просто отправляемся меню редактирования вопроса **/

            /**
             * удаляем вопрос из репозитория
             **/

            try {
                open_menu("Confirmation");
            } catch (IOException e) {
                e.printStackTrace();
            }

            field_search.setText("");
            setView(0);
        });

        setButtonAnimation();
    }

    private void open_menu(String name) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + name +  "Menu.fxml"));

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void setView(int view) {
        switch(view) {
            case 0:
                /** доступна только поле поиска **/
                field_search.setLayoutY(POS_CENTER_SEARCH_FIELD_Y);

                setActive_buttons_edit(false);
                setActive_button_addQ(false);
                setActive_scrollPanel(false);
                break;
            case 1:
                /** таблица с ответами и кнопки редактирования **/
                field_search.setLayoutY(POS_TOP_SEARCH_FIELD_Y);

                setActive_buttons_edit(true);
                setActive_button_addQ(false);
                setActive_scrollPanel(true);
                break;
            case 2:
                /** только кнопка добавить ответ **/
                field_search.setLayoutY(POS_CENTER_SEARCH_FIELD_Y);

                setActive_buttons_edit(false);
                setActive_button_addQ(true);
                setActive_scrollPanel(false);
                break;
            default:
                break;
        }
    }

    private void setActive_buttons_edit(boolean flag) {
        button_deleteQ.setVisible(flag);
        button_deleteQ.setDisable(!flag);

        button_addAnsw.setVisible(flag);
        button_addAnsw.setDisable(!flag);
    }

    private void setActive_button_addQ(boolean flag) {
        button_addQ.setVisible(flag);
        button_addQ.setDisable(!flag);
    }

    private void setActive_scrollPanel(boolean flag) {
        scroll_panel.setVisible(flag);
        scroll_panel.setDisable(!flag);
    }

    private void setButtonAnimation() {
        button_addAnsw.setOnMouseClicked(mouseEvent -> {
            button_addAnsw.setOpacity(1f);
        });

        button_addAnsw.setOnMousePressed(mouseEvent -> {
            button_addAnsw.setOpacity(0.4f);
        });

        button_addQ.setOnMouseClicked(mouseEvent -> {
            button_addQ.setOpacity(1f);
        });

        button_addQ.setOnMousePressed(mouseEvent -> {
            button_addQ.setOpacity(0.4f);
        });

        button_deleteQ.setOnMouseClicked(mouseEvent -> {
            button_deleteQ.setOpacity(1f);
        });

        button_deleteQ.setOnMousePressed(mouseEvent -> {
            button_deleteQ.setOpacity(0.4f);
        });
    }
}