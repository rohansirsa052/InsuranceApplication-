package com.CaseStudy.InsuranceApplication.Repo;

import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePlansRepo extends JpaRepository<InsurancePlans, Integer> {
}
