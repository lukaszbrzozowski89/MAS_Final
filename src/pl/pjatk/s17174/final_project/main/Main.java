/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.pjatk.s17174.final_project.utils.FileUtils;
import pl.pjatk.s17174.final_project.utils.Utils;

import java.io.IOException;
import java.io.Serializable;

/**
 * Main class to create Objects and start Application
 */
public class Main extends Application implements Serializable {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(550);
        primaryStage.setMinWidth(900);
        primaryStage.setTitle("MAS Final Project");
        primaryStage.setHeight(550);
        primaryStage.setWidth(900);
        primaryStage.show();
        primaryStage.setOnCloseRequest((event) -> {
            try {
                FileUtils.saveExtentToFile();
            } catch (IOException e) {
                Utils.showAlertDialog(e.getMessage());
                e.printStackTrace();
            }
        });
    }
}
