package com.CaseStudy.InsuranceApplication.Service;

import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import com.CaseStudy.InsuranceApplication.Repo.InsurancePlansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePlansService {
    @Autowired
    InsurancePlansRepo insurancePlansRepo;


    public List<InsurancePlans> findAll() {
        return insurancePlansRepo.findAll();
    }
}
