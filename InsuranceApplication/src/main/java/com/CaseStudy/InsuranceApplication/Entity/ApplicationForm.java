package com.CaseStudy.InsuranceApplication.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationForm {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int age;
    private double coverageAmount;
    private String gender;
    private int noOfDependents;
    private String status = "pending";

    @ManyToOne
    @JoinColumn(name="insurance_plan_id")
    private InsurancePlans insurancePlans;

}
