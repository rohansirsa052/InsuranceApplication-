package com.CaseStudy.InsuranceApplication.Repo;

import com.CaseStudy.InsuranceApplication.Entity.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ApplicationRepo extends JpaRepository<ApplicationForm, Integer> {


}
