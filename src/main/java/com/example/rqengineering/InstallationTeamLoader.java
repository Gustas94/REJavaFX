package com.example.rqengineering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstallationTeamLoader {

    public static List<InstallationTeam> readTeamsFromFile(String filePath, List<JobClass> jobs) {
        List<InstallationTeam> teams = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File(filePath))) {
            fileReader.nextLine();

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                String[] data = currentLine.split(",");

                int teamId = Integer.parseInt(data[0]);
                String teamName = data[1];
                String amountOfPeople = data[2];
                int activeJobId = Integer.parseInt(data[3]);

                JobClass activeJob = jobs.stream().filter(job -> job.getJobId() == activeJobId).findFirst().orElse(null);
                InstallationTeam team = new InstallationTeam(teamId, teamName, amountOfPeople, activeJob);
                teams.add(team);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teams;
    }
}