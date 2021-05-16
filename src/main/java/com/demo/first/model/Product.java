package com.demo.first.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    private int id;
    private String name;
    private double cartonPrice;
    private int unitPerCarton;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "carton_price")
    public double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    @Column(name = "unitPerCarton")
    public int getUnitPerCarton() {
        return unitPerCarton;
    }

    public void setUnitPerCarton(int unitPerCarton) {
        this.unitPerCarton = unitPerCarton;
    }
}
