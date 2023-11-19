package com.hexaware.medicalbillingsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.medicalbillingsystems.entities.Admin;



public interface AdminRepository extends JpaRepository<Admin, String> {

}
