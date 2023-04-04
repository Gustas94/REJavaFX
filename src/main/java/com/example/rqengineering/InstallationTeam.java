package com.example.rqengineering;

public class InstallationTeam {
    private int teamId;
    private String teamName;

    private int amountOfPeople;
    private JobClass activeJob;

    public InstallationTeam(int teamId, String teamName, int amountOfPeople, JobClass activeJob) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.activeJob = activeJob;
        this.amountOfPeople = amountOfPeople;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String amountOfPeople) {
        this.teamName = teamName;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public JobClass getActiveJob() {
        return activeJob;
    }

    public void setActiveJob(JobClass activeJob) {
        this.activeJob = activeJob;
    }


    @Override
    public String toString() {
        return getTeamId() + " - " + getTeamName();
    }
}