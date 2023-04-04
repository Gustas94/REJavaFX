package com.example.rqengineering;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Planner implements Initializable {
    @FXML
    private TableView<JobClass> jobsTableView;

    @FXML
    private TableColumn<JobClass, Integer> jobIdColumn;

    @FXML
    private TableColumn<JobClass, String> jobNameColumn;

    @FXML
    private TableColumn<JobClass, Boolean> jobIsActiveColumn;

    @FXML
    private TableColumn<JobClass, String> jobDescriptionColumn;

    @FXML
    private TableView<InstallationTeam> installationTeamsTableView;

    @FXML
    private TableColumn<InstallationTeam, Integer> installationTeamsIdColumn;

    @FXML
    private TableColumn<InstallationTeam, String> installationTeamsNameColumn;

    @FXML
    private TableColumn<InstallationTeam, Integer> installationTeamsPeopleAmountColumn;

    @FXML
    private TableColumn<InstallationTeam, String> installationTeamsIsActiveColumn;

    @FXML
    private ComboBox<JobClass> jobComboBox;
    @FXML
    private ComboBox<InstallationTeam> teamComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jobIdColumn.setCellValueFactory(new PropertyValueFactory<>("jobId"));
        jobNameColumn.setCellValueFactory(new PropertyValueFactory<>("jobName"));
        jobIsActiveColumn.setCellValueFactory(new PropertyValueFactory<>("active"));
        jobDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        fillJobsTableView();

        installationTeamsIdColumn.setCellValueFactory(new PropertyValueFactory<>("teamId"));
        installationTeamsNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        installationTeamsPeopleAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfPeople"));
        installationTeamsIsActiveColumn.setCellValueFactory(cellData -> {
            InstallationTeam team = cellData.getValue();
            SimpleStringProperty activeJobName;
            if (team.getActiveJob() != null) {
                activeJobName = new SimpleStringProperty(team.getActiveJob().getJobName());
            } else {
                activeJobName = new SimpleStringProperty("None");
            }
            return activeJobName;
        });

        fillInstallationTeamsTable();

        jobComboBox.setItems(FXCollections.observableArrayList(Application.getJobs()));
        teamComboBox.setItems(FXCollections.observableArrayList(Application.getTeams()));
    }

    @FXML
    private void linkJob() {
        System.out.println("linkJob() called."); // Debugging statement

        JobClass selectedJob = jobComboBox.getSelectionModel().getSelectedItem();
        InstallationTeam selectedTeam = teamComboBox.getSelectionModel().getSelectedItem();

        if (selectedJob != null && selectedTeam != null) {
            System.out.println("Selected job: " + selectedJob); // Debugging statement
            System.out.println("Selected team: " + selectedTeam); // Debugging statement

            // Set the active job for the selected team and update the job's isActive status
            selectedTeam.setActiveJob(selectedJob);
            selectedJob.setActive(true); // Add this line to update the job's isActive status

            // Update the jobs list in the Application class
            Application.updateJobs(Application.getJobs().stream()
                    .map(job -> job.getJobId() == selectedJob.getJobId() ? selectedJob : job)
                    .collect(Collectors.toList()));

            // Save the updated data to CSV files
            JobLoader.saveJobsToFile("src/main/resources/jobs.csv", Application.getJobs());
            InstallationTeamLoader.saveTeamsToFile("src/main/resources/InstallationTeams.csv", Application.getTeams());

            // Refresh the table views
            fillJobsTableView();
            fillInstallationTeamsTable();

            jobsTableView.refresh();
            installationTeamsTableView.refresh();
        }
    }

    private void fillJobsTableView() {
        ObservableList<JobClass> jobList = FXCollections.observableArrayList(Application.getJobs());
        jobsTableView.setItems(jobList);
    }

    private void fillInstallationTeamsTable() {
        ObservableList<InstallationTeam> installationTeamList = FXCollections.observableArrayList(Application.getTeams());
        installationTeamsTableView.setItems(installationTeamList);
    }
}
