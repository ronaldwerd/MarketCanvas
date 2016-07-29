/**
 * Market canvas display application
 *
 * @author  Ronald Partridge
 * @version 0.1
 * @since   2016-07-29
 */

package com.app.rdc.marketcanvas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Settings s = Settings.getInstance();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(s.APP_NAME);
        primaryStage.setScene(new Scene(root, s.APP_WIDTH, s.APP_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
