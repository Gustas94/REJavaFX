package com.example.rqengineering;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Installation_Teams implements Initializable {
    @FXML
    private TableView<InstallationTeam> installationTeamTable;
    @FXML
    private TableColumn<InstallationTeam, Integer> teamIdColumn;
    @FXML
    private TableColumn<InstallationTeam, String> teamNameColumn;
    @FXML
    private TableColumn<InstallationTeam, String> peopleColumn;
    @FXML
    private TableColumn<InstallationTeam, JobClass> activeJobColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamIdColumn.setCellValueFactory(new PropertyValueFactory<>("teamId"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        peopleColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfPeople"));
        activeJobColumn.setCellValueFactory(new PropertyValueFactory<>("activeJob"));

        loadInstallationTeams();
    }

    private void loadInstallationTeams() {
        ObservableList<InstallationTeam> installationTeams = FXCollections.observableArrayList(Application.getTeams());
        installationTeamTable.setItems(installationTeams);
    }
}

