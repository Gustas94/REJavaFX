package com.example.rqengineering;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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

    @FXML
    private TableColumn<Customer, Void> detailsColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        List<Customer> customersList = Application.getCustomers();


        ObservableList<Customer> customers = FXCollections.observableArrayList(customersList);

        customerTable.setItems(customers);



        detailsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button detailsButton = new Button("Details");

            {
                detailsButton.setOnAction(event -> {
                    Customer customer = getTableView().getItems().get(getIndex());
                    openCustomerDetails(customer);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(detailsButton);
                }
            }
        });
    }

    private void openCustomerDetails(Customer customer) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/rqengineering/CustomerDetails.fxml"));
            Parent root = fxmlLoader.load();
            CustomerDetails customerDetailsController = fxmlLoader.getController();
            customerDetailsController.setCustomer(customer);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Details");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

