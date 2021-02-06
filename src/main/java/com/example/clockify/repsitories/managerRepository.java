package com.example.clockify.repsitories;

import com.example.clockify.Entities.manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface managerRepository extends JpaRepository<manager,Integer> {

    public manager findAllById(int id);
}
