package com.demo.first.controller;


import com.demo.first.dto.ProductDto;
import com.demo.first.dto.ProductPriceDto;
import com.demo.first.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/priceList")
    public List<ProductPriceDto> getPriceList() {
        return productService.getPriceList();
    }


    @RequestMapping(value = "/list")
    public List<ProductDto> getProductList() {
        return productService.getProductList();
    }


}
