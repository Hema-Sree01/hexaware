package com.hexaware.medicalbillingsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.medicalbillingsystems.entities.InsuranceCompany;
@Repository
public interface InsuranceCompanyRepository  extends JpaRepository<InsuranceCompany ,Integer> {

}
