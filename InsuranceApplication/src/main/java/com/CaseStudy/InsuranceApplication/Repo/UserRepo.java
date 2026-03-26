package com.CaseStudy.InsuranceApplication.Repo;

import com.CaseStudy.InsuranceApplication.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByUserName(String username);
}
