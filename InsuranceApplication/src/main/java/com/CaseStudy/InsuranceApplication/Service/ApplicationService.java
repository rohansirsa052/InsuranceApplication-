package com.CaseStudy.InsuranceApplication.Service;

import com.CaseStudy.InsuranceApplication.Dto.ApplicationFormDto;
import com.CaseStudy.InsuranceApplication.Entity.ApplicationForm;
import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import com.CaseStudy.InsuranceApplication.Mapper.ApplicationFromMapper;
import com.CaseStudy.InsuranceApplication.Repo.ApplicationRepo;
import com.CaseStudy.InsuranceApplication.Repo.InsurancePlansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    InsurancePlansRepo insurancePlansRepo;


    public ApplicationForm saveFrom(ApplicationFormDto formDto) {
        Optional <InsurancePlans> insurancePlan =  insurancePlansRepo.findById(formDto.getInsurancePlanId());
        if (insurancePlan.isEmpty()) {
            throw new RuntimeException("Insurance Plan not found");
        }
        ApplicationForm applicationForm = ApplicationFromMapper.INSTANCE.toEntity(formDto);
        applicationForm.setInsurancePlans(insurancePlan.get());
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
