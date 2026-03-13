package com.CaseStudy.InsuranceApplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int maxAge;
    private int maxDependent;
    @OneToOne(fetch = FetchType.LAZY)
    private InsurancePlans insurancePlans;
}
