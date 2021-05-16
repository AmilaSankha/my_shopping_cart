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

    def "get Total Price single unit"() {

        given:

        int productId = 1
        String qtyType = "single_unit"

        TotalPriceDto expectedTotalPriceUnit3 = new TotalPriceDto(34.125, 0, 3)
        TotalPriceDto expectedTotalPriceUnit20 = new TotalPriceDto(175, 1, 0)
        TotalPriceDto expectedTotalPriceUnit55 = new TotalPriceDto(520.625, 2, 15)

        Product product = new Product(
                id: productId, name: "Penguin-ears", unitPerCarton: 20, cartonPrice: 175
        )

        productDao.findById(productId) >> product


        when:

        TotalPriceDto actualTotalPriceUnit3 = shoppingCartService.getTotalPrice(productId, qtyType, 3)
        TotalPriceDto actualTotalPriceUnit20 = shoppingCartService.getTotalPrice(productId, qtyType, 20)
        TotalPriceDto actualTotalPriceUnit55 = shoppingCartService.getTotalPrice(productId, qtyType, 55)


        then:

        actualTotalPriceUnit3 != null
        actualTotalPriceUnit3.totalPrice == expectedTotalPriceUnit3.totalPrice &&
                actualTotalPriceUnit3.cartonQuantity == expectedTotalPriceUnit3.cartonQuantity &&
                actualTotalPriceUnit3.singleUnitQuantity == expectedTotalPriceUnit3.singleUnitQuantity


        actualTotalPriceUnit20 != null
        actualTotalPriceUnit20.totalPrice == expectedTotalPriceUnit20.totalPrice &&
                actualTotalPriceUnit20.cartonQuantity == expectedTotalPriceUnit20.cartonQuantity &&
                actualTotalPriceUnit20.singleUnitQuantity == expectedTotalPriceUnit20.singleUnitQuantity


        actualTotalPriceUnit55 != null
        actualTotalPriceUnit55.totalPrice == expectedTotalPriceUnit55.totalPrice &&
                actualTotalPriceUnit55.cartonQuantity == expectedTotalPriceUnit55.cartonQuantity &&
                actualTotalPriceUnit55.singleUnitQuantity == expectedTotalPriceUnit55.singleUnitQuantity

    }


    def "get Total Price carton"() {

        given:

        int productId = 1
        String qtyType = "carton"

        TotalPriceDto expectedTotalPriceCarton1 = new TotalPriceDto(825, 1, 0)
        TotalPriceDto expectedTotalPriceCarton3 = new TotalPriceDto(2227.5, 3, 0)
        TotalPriceDto expectedTotalPriceCarton4 = new TotalPriceDto(2970, 4, 0)

        Product product = new Product(
                id: productId, name: "Horseshoe", unitPerCarton: 5, cartonPrice: 825
        )

        productDao.findById(productId) >> product


        when:

        TotalPriceDto actualTotalPriceCarton1 = shoppingCartService.getTotalPrice(productId, qtyType, 1)
        TotalPriceDto actualTotalPriceCarton3 = shoppingCartService.getTotalPrice(productId, qtyType, 3)
        TotalPriceDto actualTotalPriceCarton4 = shoppingCartService.getTotalPrice(productId, qtyType, 4)


        then:

        actualTotalPriceCarton1 != null
        actualTotalPriceCarton1.totalPrice == expectedTotalPriceCarton1.totalPrice &&
                actualTotalPriceCarton1.cartonQuantity == expectedTotalPriceCarton1.cartonQuantity &&
                actualTotalPriceCarton1.singleUnitQuantity == expectedTotalPriceCarton1.singleUnitQuantity


        actualTotalPriceCarton3 != null
        actualTotalPriceCarton3.totalPrice == expectedTotalPriceCarton3.totalPrice &&
                actualTotalPriceCarton3.cartonQuantity == expectedTotalPriceCarton3.cartonQuantity &&
                actualTotalPriceCarton3.singleUnitQuantity == expectedTotalPriceCarton3.singleUnitQuantity


        actualTotalPriceCarton4 != null
        actualTotalPriceCarton4.totalPrice == expectedTotalPriceCarton4.totalPrice &&
                actualTotalPriceCarton4.cartonQuantity == expectedTotalPriceCarton4.cartonQuantity &&
                actualTotalPriceCarton4.singleUnitQuantity == expectedTotalPriceCarton4.singleUnitQuantity

    }
}
