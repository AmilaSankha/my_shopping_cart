package com.demo.first.service

import com.demo.first.dao.ProductDao
import com.demo.first.dto.TotalPriceDto
import com.demo.first.model.Product
import spock.lang.Specification

class ShoppingCartServiceTest extends Specification {

    ShoppingCartService shoppingCartService;


    private ProductDao productDao = Mock(ProductDao)

    def setup() {
        shoppingCartService = new ShoppingCartService(productDao)
    }

    def "get Total Price"() {

        given:

        int productId = 1
        String qtyType = "single_unit"
        int qty = 55

        TotalPriceDto expectedTotalPrice = new TotalPriceDto(520.625, 2, 15)

        Product product = new Product(
                id: productId, name: "Penguin-ears", unitPerCarton: 20, cartonPrice: 175
        )

        productDao.findById(productId) >> product


        when:

        TotalPriceDto actualTotalPrice = shoppingCartService.getTotalPrice(productId, qtyType, qty)


        then:

        actualTotalPrice != null
        actualTotalPrice.totalPrice == expectedTotalPrice.totalPrice &&
                actualTotalPrice.cartonQuantity == expectedTotalPrice.cartonQuantity &&
                actualTotalPrice.singleUnitQuantity == expectedTotalPrice.singleUnitQuantity

    }
}
