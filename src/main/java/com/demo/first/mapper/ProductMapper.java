package com.demo.first.mapper;


import com.demo.first.dto.ProductDto;
import com.demo.first.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {


    public static ProductDto entryToDto(Product product) {

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());

        return productDto;
    }
}
