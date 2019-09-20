package com.cheatsheet;

import com.cheatsheet.service.QuestionService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import org.graalvm.compiler.phases.common.NodeCounterPhase;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("****************DEBUG TIME****************");

        QuestionService qS = QuestionService.getInstance();
        qS.create("How Old Are You?", "1. 10\n2. 15\n3. 18\n4. 20");
        qS.create("Choose name of fish", "1. beer\n2. cola\n3. name of fish\n4. salmon");

        System.out.println(qS.get(0));
        System.out.println(qS.get(1));
        System.out.println("******************************************");

        try {
            launch(args);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        primaryStage.setTitle("Меню");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
