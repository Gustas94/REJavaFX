package com.example.rqengineering;

public class JobClass {
    private int jobId;
    private String jobName;

    private String Description;

    private String Materials;
    private boolean isActive;

    public JobClass(int jobId, String jobName, String Description, String Materials, boolean isActive) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.Description = Description;
        this.Materials = Materials;
        this.isActive = isActive;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {

        return Description;
    }

    public void setDescription(String Materials){

        this.Description = Description;
    }

    public String getMaterials() {

        return Materials;
    }

    public void setMaterials(String Materials){

        this.Materials = Materials;
    }

    public boolean isActive() {

        return isActive;
    }

    public void setActive(boolean isActive) {

        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return getJobId() + " - " + getJobName();
    }
}
