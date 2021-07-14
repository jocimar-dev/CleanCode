package com.project.cleancode.usecase;

import com.project.cleancode.domain.Candidate;
import com.project.cleancode.domain.Course;
import com.project.cleancode.domain.enums.BrowserName;
import com.project.cleancode.repository.CandidateRepository;
import com.project.cleancode.usecase.exception.CandidateDoesntMeetRequirementsException;
import com.project.cleancode.usecase.exception.NoSessionApprovedException;

import java.util.Arrays;
import java.util.List;

public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository repository;

    public CandidateServiceImpl(CandidateRepository repository) {
        this.repository = repository;
    }


    @Override
    public int register(Candidate candidate) {
        validateRegistration(candidate);

        return repository.save(candidate);
    }

    private void validateRegistration(Candidate candidate) {
        validateData(candidate);

        boolean isQualified = candidateExceptional(candidate) || !obviousRedflags(candidate);

        if (!isQualified) {
            throw new CandidateDoesntMeetRequirementsException("This Candidate doesn't meet out standards.");
        }
        approveCourses(candidate);
    }

    private void validateData(Candidate candidate) throws NoSessionApprovedException {
        if (candidate.getFirstName() == null || candidate.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First Name is required.");
        }
        if (candidate.getLastName() == null || candidate.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("Last Name is required.");
        }
        if (candidate.getEmail() == null || candidate.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("Email is required.");
        }
        if (candidate.getCourseList().isEmpty()) {
            throw new IllegalArgumentException("Can't register speaker with no sessions to present.");
        }
    }

    private boolean candidateExceptional(Candidate candidate) {
        if (candidate.getYearsExperience() > 10) return true;
        if (candidate.isHasBlog()) return true;
        if (candidate.getCourseList().size() > 3) return true;

        List<String> preferredEmployers = Arrays.asList("Pluralsight", "Microsoft", "Google", "Fog Creek Software", "37Signals", "Telerik.");

        return preferredEmployers.contains(candidate.getEmployer());
    }

    private boolean obviousRedflags(Candidate candidate) {
        String emailDomain = candidate.getEmail().split("@")[1];
        List<String> ancientEmailDomain = Arrays.asList("aol.com", "hotmail.com", "prodigy.com", "compuserve.com");
        return (ancientEmailDomain.contains(emailDomain) ||
                ((candidate.getBrowser().getName() == BrowserName.INTERNET_EXPLORER
                && candidate.getBrowser().getMajorVersion() < 9)));
    }


    public void approveCourses(Candidate candidate) {
        for (Course course : candidate.getCourseList()) {
            course.setApproved(!courseIsAboutTechnology(course));
        }
        boolean noSessionApprovedException = candidate.getCourseList().stream().noneMatch(Course::isApproved);

        if (noSessionApprovedException) {
            throw new NoSessionApprovedException("No Sessions approved.");
        }
    }

    public boolean courseIsAboutTechnology(Course course) {
        List<String> oldTechnologies = Arrays.asList("Cobol", "Punch Cards", "Commodore", "VBScript");

        for (String oldTechnology : oldTechnologies) {
            if (course.getTitle().contains(oldTechnology) || course.getDescription().contains(oldTechnology)) {
                return true;
            }
        }
        return false;
    }


}

