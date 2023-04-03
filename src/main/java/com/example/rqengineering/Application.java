package com.example.rqengineering;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 375, 667);
        stage.setTitle("ECRC ENERGIZE" + " Solar panels");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        List<Customer> customers = CustomerLoader.readCustomersFromFile("src/main/resources/customers.csv");
        launch();
    }
}