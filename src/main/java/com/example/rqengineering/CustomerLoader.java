package com.example.rqengineering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerLoader {

    public static List<Customer> readCustomersFromFile(String filePath) {
        List<Customer> customers = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File(filePath))) {
            fileReader.nextLine();

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                String[] data = currentLine.split(",");

                int customerId = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String email = data[3];
                String phoneNumber = data[4];
                String address = data[5];
                String emergencyPhone = data[6];
                String activeJob = data[7];

                Customer customer = new Customer(customerId, firstName, lastName, email, phoneNumber, address, emergencyPhone, activeJob);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}