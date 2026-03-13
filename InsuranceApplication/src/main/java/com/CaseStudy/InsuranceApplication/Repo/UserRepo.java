package com.CaseStudy.InsuranceApplication.Repo;

import com.CaseStudy.InsuranceApplication.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUserName(String username);
}
