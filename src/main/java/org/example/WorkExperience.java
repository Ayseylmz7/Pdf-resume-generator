package org.example;

public class WorkExperience {
    private String company;
    private String position;
    private String duration;
    private String description;

    public WorkExperience(String company, String position, String duration, String description) {
        this.company = company;
        this.position = position;
        this.duration = duration;
        this.description = description;
    }

    // Encapsulation: Alanlara kontrollü erişim
    public String getCompany() { return company; }
    public String getPosition() { return position; }
    public String getDuration() { return duration; }
    public String getDescription() { return description; }
}