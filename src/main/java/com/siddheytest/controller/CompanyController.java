package com.siddheytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siddheytest.model.Company;
import com.siddheytest.service.CompanyService;

@RestController
@RequestMapping("/api/companies/")
public class CompanyController {

	// way one

	// @Autowired
	// private CompanyService companyService;

	// way two constructor injection

	private CompanyService companyService;
	
	public CompanyController(@Qualifier("primaryService") CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	// way three setter injection

	// @Autowired
	// public void setCompanyService(CompanyService companyService) {
	// this.companyService = companyService;
	// }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Company create(@RequestBody Company company) {
		return companyService.create(company);
	}

	@RequestMapping(value = "/addDemo", method = RequestMethod.POST)
	public Company createDemo(@RequestBody Company company) {
		return companyService.create(company);
	}

}
