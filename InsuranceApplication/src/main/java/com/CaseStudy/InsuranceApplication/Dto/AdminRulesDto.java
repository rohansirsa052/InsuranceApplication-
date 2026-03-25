package com.CaseStudy.InsuranceApplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRulesDto {

    private Integer id;
    private int maxAge;
    private int maxDependent;
    private Integer insurancePlanId;

}