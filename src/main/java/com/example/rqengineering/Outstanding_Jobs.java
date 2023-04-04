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

public class Outstanding_Jobs implements Initializable {
    @FXML
    private TableView<JobClass> outstandingJobsTable;
    @FXML
    private TableColumn<JobClass, Integer> jobIdColumn;
    @FXML
    private TableColumn<JobClass, String> nameColumn;
    @FXML
    private TableColumn<JobClass, String> isActiveColumn;
    @FXML
    private TableColumn<JobClass, String> descriptionColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jobIdColumn.setCellValueFactory(new PropertyValueFactory<>("jobId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("jobName"));
        isActiveColumn.setCellValueFactory(new PropertyValueFactory<>("active"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        loadOutstandingJobs();
    }

    private void loadOutstandingJobs() {
        ObservableList<JobClass> outstandingJobs = FXCollections.observableArrayList(Application.getJobs());
        outstandingJobsTable.setItems(outstandingJobs);
    }
}
