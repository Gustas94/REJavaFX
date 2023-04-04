package com.example.rqengineering;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application extends javafx.application.Application {

    private static List<Customer> customers;
    private static List<JobClass> jobs;
    private static List<InstallationTeam> teams;

    private static List<InstallationEmployee> employees;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 375, 667);
        stage.setTitle("ECRC ENERGIZE" + " Solar panels");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        customers = CustomerLoader.readCustomersFromFile("src/main/resources/customers.csv");
        jobs = JobLoader.readJobsFromFile("src/main/resources/jobs.csv");
        employees = InstallationEmployeesLoader.readEmployeesFromFile("src/main/resources/InstallationEmployees.csv");
        Map<Integer, Integer> teamMemberCounts = InstallationTeamLoader.countEmployeesPerTeam("src/main/resources/InstallationEmployees.csv");
        teams = InstallationTeamLoader.readTeamsFromFile("src/main/resources/InstallationTeams.csv", jobs, teamMemberCounts);
        InstallationTeamLoader.updateInstallationTeamsFile("src/main/resources/InstallationTeams.csv", teamMemberCounts);
        launch(args);
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static List<JobClass> getJobs() {
        return jobs;
    }

    public static List<InstallationTeam> getTeams() {
        return teams;
    }

    public static List<InstallationEmployee> getEmployees() {
        return employees;
    }

    public static void updateJobs(List<JobClass> updatedJobs) {
        jobs = updatedJobs;
    }


}