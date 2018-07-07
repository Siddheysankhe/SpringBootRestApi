package com.siddheytest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddheytest.model.Company;
import com.siddheytest.repository.CompanyRepository;

//@Service
@Service("inheritedService")
public class DemoInheritedServiceCompanyImpl implements CompanyService {

	// way1
	// @Autowired
	// private CompanyRepository companyRepository;

	// constructor injection

	private CompanyRepository companyRepository;

	public DemoInheritedServiceCompanyImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	// setter injection
	// @Autowired
	// public void setCompanyRepository(CompanyRepository companyRepository) {
	// this.companyRepository = companyRepository;
	// }

	@Override
	public Company create(Company company) {
		System.out.println("Executed in the DemoInheritedServiceImpl");

		companyRepository.save(company);

		return company;
	}

}
