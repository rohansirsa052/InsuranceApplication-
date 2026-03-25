package com.CaseStudy.InsuranceApplication.Service;

import com.CaseStudy.InsuranceApplication.Entity.AdminRules;
import com.CaseStudy.InsuranceApplication.Repo.AdminRulesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminRulesService {

    @Autowired
    AdminRulesRepo adminRulesRepo;


    public AdminRules setRules(AdminRules adminRules) {
        return adminRulesRepo.save(adminRules);
    }

    public String updateRules(Integer id , AdminRules adminRules) {
        Optional <AdminRules> oldAdminRules = adminRulesRepo.findById(id);
        if(oldAdminRules.isEmpty()){
            return "Invalid ID";
        }
        AdminRules newAdminRules = oldAdminRules.get();
        newAdminRules.setMaxAge(adminRules.getMaxAge());
        newAdminRules.setMaxDependent(adminRules.getMaxDependent());
        adminRulesRepo.save(newAdminRules);

        return "Admin Rules Updated";
    }
}
