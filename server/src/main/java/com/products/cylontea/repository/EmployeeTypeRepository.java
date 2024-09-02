package com.products.cylontea.repository;

import com.products.cylontea.model.Employeestatus;
import com.products.cylontea.model.Employeetype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<Employeetype,Integer> {

}
