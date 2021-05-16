package com.demo.first.dto;

public class TotalPriceDto {

    private double totalPrice;
    private int cartonQuantity;
    private int singleUnitQuantity;


    public TotalPriceDto(double totalPrice, int cartonQuantity, int singleUnitQuantity) {
        this.totalPrice = totalPrice;
        this.cartonQuantity = cartonQuantity;
        this.singleUnitQuantity = singleUnitQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCartonQuantity() {
        return cartonQuantity;
    }

    public void setCartonQuantity(int cartonQuantity) {
        this.cartonQuantity = cartonQuantity;
    }

    public int getSingleUnitQuantity() {
        return singleUnitQuantity;
    }

    public void setSingleUnitQuantity(int singleUnitQuantity) {
        this.singleUnitQuantity = singleUnitQuantity;
    }
}
