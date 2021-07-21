package com.project.cleancode.adapters.data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class CandidateData {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int yearsExperience;
    private boolean hasBlog;
    private String blogURL;
    private WebBrowserData browser;
    @ElementCollection
    private List<String> certifications;
    private String employer;
    @OneToMany
    private List<CourseData> courseDataList;
    private int registrationFee;


    public CandidateData(String firstName,
                         String lastName,
                         String email,
                         int yearsExperience,
                         boolean hasBlog,
                         String blogURL,
                         WebBrowserData browser,
                         List<String> certifications,
                         String employer,
                         List<CourseData> courseDataList,
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
        this.courseDataList = courseDataList;
        this.registrationFee = registrationFee;
    }

    @Deprecated
    public CandidateData() {

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

    public WebBrowserData getBrowser() {
        return browser;
    }

    public String getEmployer() {
        return employer;
    }

    public List<CourseData> getCourseList() {
        return courseDataList;
    }

}
