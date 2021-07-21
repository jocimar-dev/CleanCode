package com.project.cleancode.domain.usecase;

import com.project.cleancode.adapters.data.CandidateData;
import com.project.cleancode.adapters.data.CourseData;
import com.project.cleancode.domain.enums.BrowserName;
import com.project.cleancode.domain.model.Candidate;
import com.project.cleancode.domain.repository.CandidateRepository;
import com.project.cleancode.domain.usecase.exception.CandidateDoesntMeetRequirementsException;
import com.project.cleancode.domain.usecase.exception.NoSessionApprovedException;

import java.util.Arrays;
import java.util.List;


public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository repository;

    public CandidateServiceImpl(CandidateRepository repository) {
        this.repository = repository;
    }


    @Override
    public Candidate register(CandidateData candidateData) {
        validateRegistration(candidateData);

        return repository.saveCandidate(candidateData);
    }

    private void validateRegistration(CandidateData candidateData) {

        boolean isQualified = candidateExceptional(candidateData) || !obviousRedflags(candidateData);

        if (!isQualified) {
            throw new CandidateDoesntMeetRequirementsException("This Candidate doesn't meet out standards.");
        }
        approveCourses(candidateData);
    }

    private boolean candidateExceptional(CandidateData candidateData) {
        if (candidateData.getYearsExperience() > 10) return true;
        if (candidateData.isHasBlog()) return true;
        if (candidateData.getCourseList().size() > 3) return true;

        List<String> preferredEmployers = Arrays.asList("Pluralsight", "Microsoft", "Google", "Fog Creek Software", "37Signals", "Telerik.");

        return preferredEmployers.contains(candidateData.getEmployer());
    }

    private boolean obviousRedflags(CandidateData candidateData) {
        String emailDomain = candidateData.getEmail().split("@")[1];
        List<String> ancientEmailDomain = Arrays.asList("aol.com", "hotmail.com", "prodigy.com", "compuserve.com");
        return (ancientEmailDomain.contains(emailDomain) ||
                ((candidateData.getBrowser().getName() == BrowserName.INTERNET_EXPLORER
                && candidateData.getBrowser().getMajorVersion() < 9)));
    }


    public void approveCourses(CandidateData candidateData) {
        for (CourseData courseData : candidateData.getCourseList()) {
            courseData.setApproved(!courseIsAboutTechnology(courseData));
        }
        boolean noSessionApprovedException = candidateData.getCourseList().stream().noneMatch(CourseData::isApproved);

        if (noSessionApprovedException) {
            throw new NoSessionApprovedException("No Sessions approved.");
        }
    }

    public boolean courseIsAboutTechnology(CourseData courseData) {
        List<String> oldTechnologies = Arrays.asList("Cobol", "Punch Cards", "Commodore", "VBScript");

        for (String oldTechnology : oldTechnologies) {
            if (courseData.getTitle().contains(oldTechnology) || courseData.getDescription().contains(oldTechnology)) {
                return true;
            }
        }
        return false;
    }


}

