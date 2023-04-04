package com.example.rqengineering;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

public class CustomerForm {
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emergencyPhoneField;

    @FXML
    private TextField activeJobField;

    @FXML
    private Label messageLabel;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    public void saveCustomerInformation() throws IOException {
        String customerId = String.valueOf(Application.getCustomers().size() + 1);
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String address = addressField.getText();
        String emergencyPhone = emergencyPhoneField.getText();
        String activeJob = activeJobField.getText();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        boolean isActive = endDate == null || endDate.isAfter(LocalDate.now());

        // Add validations for the input fields here
        if (isAnyFieldEmpty()) {
            messageLabel.setText("Please fill in all the fields!");
        } else if (customerExists(email, phoneNumber, address, emergencyPhone)) {
            messageLabel.setText("Customer with this information already exists!");
        } else {
            Customer newCustomer = new Customer(Integer.parseInt(customerId), firstName, lastName, email, phoneNumber, address, emergencyPhone, activeJob);
            Application.getCustomers().add(newCustomer);

            String customerData = String.join(",", customerId, firstName, lastName, email, phoneNumber, address, emergencyPhone, activeJob);
            Files.write(Paths.get("src/main/resources/customers.csv"), ("\n" + customerData).getBytes(), StandardOpenOption.APPEND);

            firstNameField.clear();
            lastNameField.clear();
            emailField.clear();
            phoneNumberField.clear();
            addressField.clear();
            emergencyPhoneField.clear();
            activeJobField.clear();

            Stage stage = (Stage) activeJobField.getScene().getWindow();
            stage.close();
        }
    }

    private boolean customerExists(String email, String phoneNumber, String address, String emergencyPhone) {
        List<Customer> customers = Application.getCustomers();

        for (Customer customer : customers) {
            if (customer.getEmail().equalsIgnoreCase(email) ||
                    customer.getPhoneNumber().equals(phoneNumber) ||
                    customer.getAddress().equalsIgnoreCase(address) ||
                    customer.getEmergencyPhone().equals(emergencyPhone)) {
                return true;
            }
        }

        return false;
    }

    private boolean isAnyFieldEmpty() {
        return firstNameField.getText().isEmpty() ||
                lastNameField.getText().isEmpty() ||
                emailField.getText().isEmpty() ||
                phoneNumberField.getText().isEmpty() ||
                addressField.getText().isEmpty() ||
                emergencyPhoneField.getText().isEmpty() ||
                activeJobField.getText().isEmpty();
    }
}