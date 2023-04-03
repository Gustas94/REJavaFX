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

public class CEO implements Initializable {

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

    @FXML
    private TableView<JobClass> jobTable;
    @FXML
    private TableColumn<JobClass, Integer> jobIdColumn;
    @FXML
    private TableColumn<JobClass, String> nameColumn;
    @FXML
    private TableColumn<JobClass, String> isActiveColumn;
    @FXML
    private TableColumn<JobClass, String> descriptionColumn;

    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, Integer> customerIdColumn;
    @FXML
    private TableColumn<Customer, String> firstNameColumn;
    @FXML
    private TableColumn<Customer, String> lastNameColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;
    @FXML
    private TableColumn<Customer, String> phoneNumberColumn;
    @FXML
    private TableColumn<Customer, String> addressColumn;
    @FXML
    private TableColumn<Customer, String> emergencyPhoneColumn;
    @FXML
    private TableColumn<Customer, String> customerActiveJobColumn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set cell value factories
        teamIdColumn.setCellValueFactory(new PropertyValueFactory<>("teamId"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        peopleColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfPeople"));
        activeJobColumn.setCellValueFactory(new PropertyValueFactory<>("activeJob"));

        jobIdColumn.setCellValueFactory(new PropertyValueFactory<>("jobId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("jobName"));
        isActiveColumn.setCellValueFactory(new PropertyValueFactory<>("active"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emergencyPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("emergencyPhone"));
        customerActiveJobColumn.setCellValueFactory(new PropertyValueFactory<>("activeJob"));

        loadInstallationTeams();
        loadJobs();
        loadCustomers();
    }

    private void loadInstallationTeams() {
        ObservableList<InstallationTeam> installationTeams = FXCollections.observableArrayList(Application.getTeams());
        installationTeamTable.setItems(installationTeams);
    }

    private void loadJobs() {
        ObservableList<JobClass> jobList = FXCollections.observableArrayList(Application.getJobs());
        jobTable.setItems(jobList);
    }
    private void loadCustomers() {
        ObservableList<Customer> customers = FXCollections.observableArrayList(Application.getCustomers());
        customerTable.setItems(customers);
    }
}