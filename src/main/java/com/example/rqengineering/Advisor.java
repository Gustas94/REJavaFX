package com.example.rqengineering;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Advisor {

    @FXML
    private Button checkPowerConsumptionButton;

    @FXML
    private Label powerConsumptionLabel;

    @FXML
    public void initialize() {
        checkPowerConsumptionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkPowerConsumption();
            }
        });
    }



    private void checkPowerConsumption() {
        Random random = new Random();
        int powerConsumption = 5000 + random.nextInt(2001);
        if (powerConsumption > 6000) {
            powerConsumptionLabel.setStyle("-fx-text-fill: red;");
            powerConsumptionLabel.setText("Power consumption of the client is above 6000W: " + powerConsumption + "W");
        } else {
            powerConsumptionLabel.setStyle("-fx-text-fill: black;");
            powerConsumptionLabel.setText("Power consumption of the client is: " + powerConsumption + "W");
        }
    }

    @FXML
    private void openCustomerForm(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerForm.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Customer Information");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
