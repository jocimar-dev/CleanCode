package com.project.cleancode.domain;

import java.util.List;


public class Candidate {

    private String firstName;
    private String lastName;
    private String email;
    private int yearsExperience;
    private boolean hasBlog;
    private String blogURL;
    private WebBrowser browser;
    private List<String> certifications;
    private String employer;
    private List<Course> courseList;
    private int registrationFee;

    public Candidate(String firstName,
                     String lastName,
                     String email,
                     int yearsExperience,
                     boolean hasBlog,
                     String blogURL,
                     WebBrowser browser,
                     List<String> certifications,
                     String employer,
                     List<Course> courseList,
                     int registrationFee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearsExperience = yearsExperience;
        this.hasBlog = hasBlog;
        this.blogURL = blogURL;
        this.browser = browser;
        this.certifications = certifications;
        this.employer = employer;
        this.courseList = courseList;
        this.registrationFee = registrationFee;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public boolean isHasBlog() {
        return hasBlog;
    }

    public String getBlogURL() {
        return blogURL;
    }

    public WebBrowser getBrowser() {
        return browser;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public String getEmployer() {
        return employer;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public int getRegistrationFee() {
        return registrationFee;
    }
}
