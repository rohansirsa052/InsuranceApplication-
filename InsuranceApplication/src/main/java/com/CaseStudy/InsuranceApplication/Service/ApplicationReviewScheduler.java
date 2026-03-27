package com.CaseStudy.InsuranceApplication.Service;

import com.CaseStudy.InsuranceApplication.Entity.AdminRules;
import com.CaseStudy.InsuranceApplication.Entity.ApplicationForm;
import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import com.CaseStudy.InsuranceApplication.Repo.AdminRulesRepo;
import com.CaseStudy.InsuranceApplication.Repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationReviewScheduler {

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    AdminRulesRepo adminRulesRepo;

    @Scheduled(fixedRate = 300000 ) // Every 5 min
    public void reviewApplication(){

        System.out.println("Scheduler Started!");

        // Fetch all pending applications

        List<ApplicationForm> pendingApplications = applicationRepo.findByStatus("pending");

        if(pendingApplications.isEmpty()){
            System.out.println("No pending Applications found");
        }
        // Process each pending applications

        for(ApplicationForm application: pendingApplications){
            int age = application.getAge();
            int NoOfDependent = application.getNoOfDependents();

            InsurancePlans insurancePlans = application.getInsurancePlans();
            int insurancePlanId = insurancePlans.getId();

            AdminRules adminRules = adminRulesRepo.findById(insurancePlanId)
                    .orElseThrow(() -> new RuntimeException("AdminRules not found for id: " + insurancePlanId));

            int maxAge = adminRules.getMaxAge();
            int maxDependent = adminRules.getMaxDependent();

            if(age > maxAge || NoOfDependent > maxDependent){
                System.out.println("Application " + application.getId() + " Rejected!!");
                application.setStatus("Rejected");
            }
            else{
                application.setStatus("Approved");
                System.out.println("Application " + application.getId() + " Approved!!");
            }
            applicationRepo.save(application);
        }

    }
}
