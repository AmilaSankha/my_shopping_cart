package com.demo.first.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {


    @RequestMapping(value = "/priceList")
    public String getPriceList() {
        return "priceList";
    }

    @RequestMapping(value = "/shoppingCart")
    public String getShoppingCart() {
        return "shoppingCart";
    }

}
