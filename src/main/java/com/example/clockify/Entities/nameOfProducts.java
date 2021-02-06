package com.example.clockify.Entities;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "name_products")
public class nameOfProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "count_poduct")
    private int countOfProduct;

    @Column(name = "price")
    private long price;

    @Column(name = "name_product")
    private  String nameOFproduct;

    public nameOfProducts(int countOfProduct,long price, String nameOFproduct) {
        this.countOfProduct = countOfProduct;
        this.price = price;
        this.nameOFproduct = nameOFproduct;
    }

    public nameOfProducts() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNameOFproduct() {
        return nameOFproduct;
    }

    public void setNameOFproduct(String nameOFproduct) {
        this.nameOFproduct = nameOFproduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(int countOfProduct) {
        this.countOfProduct = countOfProduct;
    }
}
