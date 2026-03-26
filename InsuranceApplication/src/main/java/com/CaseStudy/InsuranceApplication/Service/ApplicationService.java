package com.CaseStudy.InsuranceApplication.Service;

import com.CaseStudy.InsuranceApplication.Dto.ApplicationFormDto;
import com.CaseStudy.InsuranceApplication.Entity.ApplicationForm;
import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import com.CaseStudy.InsuranceApplication.Entity.Users;
import com.CaseStudy.InsuranceApplication.Mapper.ApplicationFormMapper;
import com.CaseStudy.InsuranceApplication.Repo.ApplicationRepo;
import com.CaseStudy.InsuranceApplication.Repo.InsurancePlansRepo;
import com.CaseStudy.InsuranceApplication.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    InsurancePlansRepo insurancePlansRepo;

    @Autowired
    UserRepo userRepo;


    public ApplicationForm saveForm(ApplicationFormDto formDto) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Users user = userRepo.findByUserName(username).orElseThrow(()-> new RuntimeException("Invalid User"));
        if (!username.equals(formDto.getName())) {
            throw new RuntimeException("You cannot apply for another user");
        }
        InsurancePlans insurancePlan = insurancePlansRepo
                .findById(formDto.getInsurancePlanId())
                .orElseThrow(() -> new RuntimeException("Insurance Plan not found"));

        ApplicationForm applicationForm = ApplicationFormMapper.INSTANCE.toEntity(formDto);

        applicationForm.setInsurancePlans(insurancePlan);

        return applicationRepo.save(applicationForm);
    }

    public ApplicationForm findById(Integer applicationId) {
        Optional <ApplicationForm> fetchedApplication = applicationRepo.findById(applicationId);
        if(fetchedApplication.isEmpty()){
            return null;
        }

        return fetchedApplication.get();
    }
}
