package com.siddheytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siddheytest.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
