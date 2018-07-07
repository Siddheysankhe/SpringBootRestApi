package com.siddheytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siddheytest.model.Product;

//This will be AUTO IMPLEMENTED by Spring into a Bean called productrepository

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
