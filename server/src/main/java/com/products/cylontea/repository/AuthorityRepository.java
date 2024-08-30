package com.products.cylontea.repository;

import com.products.cylontea.model.Authority;
import com.products.cylontea.model.Module;
import com.products.cylontea.model.Operation;
import com.products.cylontea.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    boolean existsByRoleAndModuleAndOperation(Role role, Module module, Operation operation);
}
