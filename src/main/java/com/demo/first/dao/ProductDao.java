package com.demo.first.dao;

import com.demo.first.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

    Product findById(int id);

}
