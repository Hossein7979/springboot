package com.example.clockify.repsitories;

import com.example.clockify.Entities.nameOfProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface nameProduct extends JpaRepository<nameOfProducts,Integer> {
}
