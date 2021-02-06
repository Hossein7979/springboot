package com.example.clockify.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Type_product")
public class typeOfProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "type_product")
    private String typeOfProduct;

    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "common_product",referencedColumnName = "id")
     List<nameOfProducts>nameOfProductsList=new ArrayList<>();

    public typeOfProducts() {

    }

    public List<nameOfProducts> getNameOfProductsList() {
        return nameOfProductsList;
    }

    public void setNameOfProductsList(List<nameOfProducts> nameOfProductsList) {
        this.nameOfProductsList = nameOfProductsList;
    }

    public int getId() {
        return id;
    }

    public typeOfProducts( String typeOfProduct) {

        this.typeOfProduct = typeOfProduct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }
}
