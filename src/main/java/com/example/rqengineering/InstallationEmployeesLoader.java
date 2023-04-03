package com.example.rqengineering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstallationEmployeesLoader {

    public static List<InstallationEmployee> readEmployeesFromFile(String filePath) {
        List<InstallationEmployee> employees = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File(filePath))) {
            fileReader.nextLine();

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                String[] data = currentLine.split(",");

                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String phoneNumber = data[3];
                int teamId = Integer.parseInt(data[4]);
                String teamName = data[5];

                InstallationEmployee employee = new InstallationEmployee(id, firstName, lastName, phoneNumber, teamId, teamName);
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

}
