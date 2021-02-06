package com.example.clockify.repsitories;

import com.example.clockify.Entities.typeOfProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface typeProduct extends JpaRepository<typeOfProducts, Integer> {

    public typeProduct findAllById(int id);
}
