package com.demo.first.service;

import com.demo.first.dao.ProductDao;
import com.demo.first.dto.TotalPriceDto;
import com.demo.first.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private final static String QTY_TYPE_CARTON = "carton";
    private final static String QTY_TYPE_SINGLE_UNIT = "single_unit";

    private final ProductDao productDao;

    @Autowired
    public ShoppingCartService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public TotalPriceDto getTotalPrice(int productId, String quantityType, int quantity) {
        int cartonQty = 0;
        int singleUnitQty = 0;
        Product product = productDao.findById(productId);

        if (QTY_TYPE_CARTON.equals(quantityType)) {
            cartonQty = quantity;
        } else if (QTY_TYPE_SINGLE_UNIT.equals(quantityType)) {
            cartonQty = quantity / product.getUnitPerCarton();
            singleUnitQty = quantity % product.getUnitPerCarton();
        }


        double priceWithoutDiscount = getPriceWithoutDiscount(cartonQty, singleUnitQty, product);

        double totalPrice = priceWithoutDiscount - getDiscount(cartonQty, priceWithoutDiscount);

        return new TotalPriceDto(totalPrice, cartonQty, singleUnitQty);
    }

    private double getPriceWithoutDiscount(int cartonQty, int singleUnitQty, Product product) {
        return cartonQty * product.getCartonPrice()
                + singleUnitQty * (product.getCartonPrice() / product.getUnitPerCarton()) * 1.3; // add 30% for single unit
    }

    private double getDiscount(int cartonQty, double priceWithoutDiscount) {
        if (cartonQty >= 3) return priceWithoutDiscount * 0.1; // 10% discount if carton count >= 3
        return 0;
    }
}
