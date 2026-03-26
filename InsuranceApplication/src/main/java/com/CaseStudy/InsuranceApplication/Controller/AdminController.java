package com.CaseStudy.InsuranceApplication.Controller;

import com.CaseStudy.InsuranceApplication.Dto.AdminRulesDto;
import com.CaseStudy.InsuranceApplication.Entity.AdminRules;
import com.CaseStudy.InsuranceApplication.Entity.ApplicationForm;
import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import com.CaseStudy.InsuranceApplication.Service.AdminRulesService;
import com.CaseStudy.InsuranceApplication.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminRulesService adminRulesService;

    @Autowired
    ApplicationService applicationService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/setRules")
    public ResponseEntity <AdminRules> setRules(@RequestBody AdminRulesDto adminRulesDto){
        AdminRules savedAdminRules = adminRulesService.setRules(adminRulesDto);
        return new ResponseEntity<>(savedAdminRules, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/setPlans")
    public ResponseEntity <InsurancePlans> setInsurancePlans(@RequestBody InsurancePlans insurancePlans){
        InsurancePlans savedInsurancePlans = adminRulesService.setPlans(insurancePlans);
        return new ResponseEntity<>(savedInsurancePlans, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateRules/{id}")
    public ResponseEntity <String> updateRules(@RequestBody AdminRules adminRules, @PathVariable Integer id){
        String result = adminRulesService.updateRules(id, adminRules);
        if(result.equals("Invalid ID")){
            return  new ResponseEntity<>("Please Enter the valid id", HttpStatus.NOT_FOUND);
        }
       else
           return new ResponseEntity<>("Admin Rules Updated", HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/application/{id}")
    public ResponseEntity <ApplicationForm> getApplicationById(@PathVariable Integer applicationId){
        ApplicationForm applicationForm = applicationService.findById(applicationId);
        if(applicationForm == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(applicationForm, HttpStatus.OK);
    }
}
