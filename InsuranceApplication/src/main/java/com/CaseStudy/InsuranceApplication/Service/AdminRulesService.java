package com.CaseStudy.InsuranceApplication.Service;

import com.CaseStudy.InsuranceApplication.Dto.AdminRulesDto;
import com.CaseStudy.InsuranceApplication.Entity.AdminRules;
import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import com.CaseStudy.InsuranceApplication.Mapper.AdminRulesMapper;
import com.CaseStudy.InsuranceApplication.Repo.AdminRulesRepo;
import com.CaseStudy.InsuranceApplication.Repo.InsurancePlansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminRulesService {

    @Autowired
    AdminRulesRepo adminRulesRepo;

    @Autowired
    InsurancePlansRepo insurancePlansRepo;

    public AdminRules setRules(AdminRulesDto adminRulesDto) {
        InsurancePlans plan = insurancePlansRepo
                .findById(adminRulesDto.getInsurancePlanId())
                .orElseThrow(() -> new RuntimeException("Insurance plan not found"));

        AdminRules rules = AdminRulesMapper.INSTANCE.toEntity(adminRulesDto);
        rules.setInsurancePlans(plan);

        return adminRulesRepo.save(rules);
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

    public InsurancePlans setPlans(InsurancePlans insurancePlans) {
        return insurancePlansRepo.save(insurancePlans);
    }
}
