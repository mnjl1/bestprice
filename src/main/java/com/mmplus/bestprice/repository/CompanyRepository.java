package com.mmplus.bestprice.repository;

import com.mmplus.bestprice.entity.profile.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
