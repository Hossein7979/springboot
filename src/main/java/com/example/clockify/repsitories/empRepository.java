package com.example.clockify.repsitories;

import com.example.clockify.Entities.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empRepository extends JpaRepository<employee,Integer> {

    public employee findAllById(int id);

}
