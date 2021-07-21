package com.project.cleancode.domain.model;

public class Course {
    private String title;
    private String description;
    private boolean approved;

    public Course(String title,
                  String description,
                  boolean approved) {
        this.title = title;
        this.description = description;
        this.approved = approved;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
