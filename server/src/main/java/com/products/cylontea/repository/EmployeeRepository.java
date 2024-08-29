package com.products.cylontea.repository;

import com.products.cylontea.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByNumber(String number);
    boolean existsByMobile(String mobile);
    boolean existsByNic(String nic);
}
