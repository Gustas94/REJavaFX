package com.example.rqengineering;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label loginStatusLabel;

    @FXML
    protected void onLoginButtonClick() {
        loginStatusLabel.setText("Welcome to JavaFX Application!");
    }
}