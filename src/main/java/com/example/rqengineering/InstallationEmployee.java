package com.example.rqengineering;

public class InstallationEmployee {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int teamId;
    private String teamName;

    public InstallationEmployee(int id, String firstName, String lastName, String phoneNumber, int teamId, String teamName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }
}
