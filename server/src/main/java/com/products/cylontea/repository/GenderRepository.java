package com.products.cylontea.repository;


import com.products.cylontea.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,Integer> {

}
