package com.siddheytest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product{

	@Id
	@GeneratedValue
	@Column(name="PRODUCT_ID")
	private Long id;
	
	
	private String name;
	private String description;
	private String conditionOfProduct;
	
	
	//mapping part onetomany
	
	@ManyToOne
	@JoinColumn(name="companies_COMPANY_ID")
	private Company company;
	
	
	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, String description, String conditionOfProduct) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.conditionOfProduct = conditionOfProduct;
	}



	public String getConditionOfProduct() {
		return conditionOfProduct;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setCondition(String conditionOfProduct) {
		this.conditionOfProduct = conditionOfProduct;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
