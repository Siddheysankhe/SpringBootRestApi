package com.siddheytest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.siddheytest.model.Company;
import com.siddheytest.repository.CompanyRepository;


@Service("primaryService")
//@Service
//@Primary
public class CompanyServiceImpl implements CompanyService {
	
	//way 1
	
//	@Autowired
//	private CompanyRepository companyRepository;
	
	
	// way 2 constructor injection
	
	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	//way 3 setter injection
	
	// @Autowired
	// public void setCompanyRepository(CompanyRepository companyRepository) {
	// this.companyRepository = companyRepository;
	// }

	
	public Company create(Company company) {
		
		System.out.println("Executed in the CompanyServiceImpl");
		companyRepository.save(company);
		
		return company;
	}
}
