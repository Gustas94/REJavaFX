package com.example.rqengineering;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class LoginController extends Application{
    @FXML
    private Label welcomeText;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginStatusLabel;

    private List<User> users = new ArrayList<>();

    public void initialize() {
        loadUsers();
    }


    private void loadUsers() {
        try (Scanner fileReader = new Scanner(new File("src/main/resources/users.csv"))) {
            fileReader.nextLine();

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                String[] parts = currentLine.split(",");
                users.add(new User(parts[0], parts[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onLoginButtonClick() throws IOException {
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        User loggedInUser = null;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                break;
            }
        }

        if (loggedInUser != null) {
            UserManager.setCurrentUser(loggedInUser);
            loginStatusLabel.setText("Login successful!");

            Stage currentStage = (Stage) loginStatusLabel.getScene().getWindow();
            String fxmlFile = "";

            if (username.equals("CEO")) {
                fxmlFile = "/com/example/rqengineering/CEO.fxml";
            } else if (username.equals("Planner")) {
                fxmlFile = "/com/example/rqengineering/Planner.fxml";
            } else if (username.equals("Advisor")) {
                fxmlFile = "/com/example/rqengineering/Advisor.fxml";
            } else if (username.equals("Installation")) {
                fxmlFile = "/com/example/rqengineering/Installation.fxml";
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Scene scene = new Scene(root, 375, 667);
            currentStage.setScene(scene);


        } else {
            loginStatusLabel.setText("Invalid username or password.");
        }
    }
}
