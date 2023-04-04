package com.example.rqengineering;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CEO{

    @FXML
    private void viewInstallationTeams() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/rqengineering/installation_teams.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Installation Teams");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewOutstandingJobs() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/rqengineering/outstanding_jobs.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Outstanding Jobs");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void viewCustomers() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/rqengineering/customers.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Customers");
        stage.setScene(new Scene(root));
        stage.show();
    }
}