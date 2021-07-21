package com.project.cleancode.domain.model;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class Candidate {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    private int yearsExperience;
    private boolean hasBlog;
    private String blogURL;
    private WebBrowser browser;
    @NotBlank
    private List<String> certifications;
    private String employer;


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private List<Course> courseList;
    private int registrationFee;


    public Candidate(Candidate candidate) {
        this.firstName = getFirstName();
        this.lastName = getLastName();
        this.email = getEmail();
        this.yearsExperience = getYearsExperience();
        this.hasBlog = isHasBlog();
        this.blogURL = getBlogURL();
        this.browser = getBrowser();
        this.certifications = getCertifications();
        this.employer = getEmployer();
        this.courseList = getCourseList();
        this.registrationFee = getRegistrationFee();
    }

    public int getRegistrationFee() {
        return registrationFee;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public String getBlogURL() {
        return blogURL;
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

    public WebBrowser getBrowser() {
        return browser;
    }

    public String getEmployer() {
        return employer;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

}
