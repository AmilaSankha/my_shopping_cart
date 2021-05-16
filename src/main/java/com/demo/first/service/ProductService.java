package com.demo.first.service;


import com.demo.first.dao.ProductDao;
import com.demo.first.dto.ProductDto;
import com.demo.first.dto.ProductPriceDto;
import com.demo.first.mapper.ProductMapper;
import com.demo.first.mapper.ProductPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }


    public List<ProductPriceDto> getPriceList() {
        return productDao.findAll().stream().map(ProductPriceMapper::entryToDto).collect(Collectors.toList());
    }

    public List<ProductDto> getProductList() {
        return productDao.findAll().stream().map(ProductMapper::entryToDto).collect(Collectors.toList());
    }


}
