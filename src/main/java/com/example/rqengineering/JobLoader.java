package com.example.rqengineering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobLoader {

    public static List<JobClass> readJobsFromFile(String filePath) {
        List<JobClass> jobs = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File(filePath))) {
            fileReader.nextLine();

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                String[] data = currentLine.split(",");

                int jobId = Integer.parseInt(data[0]);
                String jobName = data[1];
                String Description = data[2];
                String Materials = data[3];
                boolean isActive = Boolean.parseBoolean(data[4]);

                JobClass job = new JobClass(jobId, jobName, Description, Materials, isActive);
                jobs.add(job);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jobs;
    }
}