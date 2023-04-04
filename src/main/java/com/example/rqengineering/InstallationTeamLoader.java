package com.example.rqengineering;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InstallationTeamLoader {

    public static List<InstallationTeam> readTeamsFromFile(String filePath, List<JobClass> jobs, Map<Integer, Integer> teamMemberCounts) {
        List<InstallationTeam> teams = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File(filePath))) {
            fileReader.nextLine();

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                String[] data = currentLine.split(",");

                int teamId = Integer.parseInt(data[0]);
                String teamName = data[1];
                int amountOfPeople = teamMemberCounts.getOrDefault(teamId, 0);
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

    public static Map<Integer, Integer> countEmployeesPerTeam(String filePath) {
        Map<Integer, Integer> teamMemberCounts = new HashMap<>();

        try (Scanner fileReader = new Scanner(new File(filePath))) {
            fileReader.nextLine();

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                String[] data = currentLine.split(",");

                int teamId = Integer.parseInt(data[4]);
                teamMemberCounts.put(teamId, teamMemberCounts.getOrDefault(teamId, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teamMemberCounts;
    }

    public static void updateInstallationTeamsFile(String filePath, Map<Integer, Integer> teamMemberCounts) {
        List<String> updatedLines = new ArrayList<>();

        try (Scanner fileReader = new Scanner(new File(filePath))) {
            if (fileReader.hasNext()) {
                updatedLines.add(fileReader.nextLine());
            }

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                String[] data = currentLine.split(",");

                int teamId = Integer.parseInt(data[0]);
                data[2] = String.valueOf(teamMemberCounts.getOrDefault(teamId, 0));

                String updatedLine = String.join(",", data);
                updatedLines.add(updatedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the updated lines back to the file
        try (PrintWriter fileWriter = new PrintWriter(new File(filePath))) {
            for (String updatedLine : updatedLines) {
                fileWriter.println(updatedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveTeamsToFile(String filePath, List<InstallationTeam> teams) {
        try (PrintWriter fileWriter = new PrintWriter(new File(filePath))) {
            fileWriter.println("teamId,teamName,amountOfPeople,activeJobId");
            for (InstallationTeam team : teams) {
                int activeJobId = team.getActiveJob() != null ? team.getActiveJob().getJobId() : 0;
                fileWriter.println(team.getTeamId() + "," + team.getTeamName() + "," + team.getAmountOfPeople() + "," + activeJobId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}