package com.example.rqengineering;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Customers implements Initializable {
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
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emergencyPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("emergencyPhone"));
        customerActiveJobColumn.setCellValueFactory(new PropertyValueFactory<>("activeJob"));

        // Get the customers from the Application class
        List<Customer> customersList = Application.getCustomers();

        // Convert the List<Customer> to ObservableList<Customer>
        ObservableList<Customer> customers = FXCollections.observableArrayList(customersList);

        customerTable.setItems(customers);
    }
}

