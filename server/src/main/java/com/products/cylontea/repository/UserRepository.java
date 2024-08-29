package com.products.cylontea.repository;

import com.products.cylontea.model.Employee;
import com.products.cylontea.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

   boolean existsByUsername(String username);
}
