package com.example.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BudgetApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("budget.fxml"));
        Scene scene  = new Scene(fxmlLoader.load());
      primaryStage.setScene(scene);
      primaryStage.setTitle("Budget Expense Program");
      primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}