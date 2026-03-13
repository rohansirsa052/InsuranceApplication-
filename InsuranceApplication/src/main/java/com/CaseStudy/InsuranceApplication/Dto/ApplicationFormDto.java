package com.CaseStudy.InsuranceApplication.Dto;

import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationFormDto {

    private String name;
    private int age;
    private double coverageAmount;
    private String gender;
    private int noOfDependents;
    private Integer insurancePlanId;
}
