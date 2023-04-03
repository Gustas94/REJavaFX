package com.example.rqengineering;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CEO {

    @FXML
    public Label CEOLabel;

    public void printCEO() {
        CEOLabel.setText("CEO");
    }

    @FXML
    public void initialize() {
        printCEO();
    }
}
