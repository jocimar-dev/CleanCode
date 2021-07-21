package com.project.cleancode.adapters.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CourseData {
    @Id
    private Long id;
    private String title;
    private String description;
    private boolean approved;

    public CourseData(String title,
                      String description,
                      boolean approved) {
        this.title = title;
        this.description = description;
        this.approved = approved;
    }

    @Deprecated
    public CourseData() {
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
