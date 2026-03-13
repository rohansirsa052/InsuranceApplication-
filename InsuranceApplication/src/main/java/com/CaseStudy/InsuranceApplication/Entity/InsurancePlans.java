package com.CaseStudy.InsuranceApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double coverageAmount;
    private double insuranceAmount;
    private double monthlyInstallment;
    private String description;
    private String typeOfInsurance;

    @OneToMany(mappedBy = "insurancePlans")
    @JsonIgnore
    private List<ApplicationForm> applicationForms;
}
