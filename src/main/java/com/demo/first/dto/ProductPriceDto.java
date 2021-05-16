package com.demo.first.dto;

public class ProductPriceDto {

    private String name;
    private double cartonPrice;
    private int unitPerCarton;


    public ProductPriceDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public int getUnitPerCarton() {
        return unitPerCarton;
    }

    public void setUnitPerCarton(int unitPerCarton) {
        this.unitPerCarton = unitPerCarton;
    }
}
