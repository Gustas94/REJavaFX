package com.example.rqengineering;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CustomerDetails {
    @FXML
    private Label customerIdLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneNumberLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label emergencyPhoneLabel;
    @FXML
    private Label customerActiveJobLabel;


    public void setCustomer(Customer customer) {
        customerIdLabel.setText(String.valueOf(customer.getCustomerId()));
        firstNameLabel.setText(customer.getFirstName());
        lastNameLabel.setText(customer.getLastName());
        emailLabel.setText(customer.getEmail());
        phoneNumberLabel.setText(customer.getPhoneNumber());
        addressLabel.setText(customer.getAddress());
        emergencyPhoneLabel.setText(customer.getEmergencyPhone());
        customerActiveJobLabel.setText(customer.getActiveJob());

    }




}
