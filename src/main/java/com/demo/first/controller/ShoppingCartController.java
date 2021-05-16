package com.demo.first.controller;


import com.demo.first.dto.TotalPriceDto;
import com.demo.first.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @RequestMapping(value = "/totalPrice")
    public TotalPriceDto getTotalPrice(@RequestParam int id, @RequestParam String quantityType, @RequestParam int quantity) {
        return shoppingCartService.getTotalPrice(id, quantityType, quantity);
    }


}
