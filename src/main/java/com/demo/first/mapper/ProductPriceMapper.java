package com.demo.first.mapper;


import com.demo.first.dto.ProductPriceDto;
import com.demo.first.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceMapper {


    public static ProductPriceDto entryToDto(Product product) {

        ProductPriceDto productPriceDto = new ProductPriceDto();
        productPriceDto.setName(product.getName());
        productPriceDto.setCartonPrice(product.getCartonPrice());
        productPriceDto.setUnitPerCarton(product.getUnitPerCarton());

        return productPriceDto;
    }
}
