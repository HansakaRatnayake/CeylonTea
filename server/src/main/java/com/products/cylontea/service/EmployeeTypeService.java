package com.products.cylontea.service;


import com.products.cylontea.dto.EmployeeTypeDTO;
import com.products.cylontea.model.Employeetype;
import com.products.cylontea.repository.EmployeeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeTypeService {


    List<EmployeeTypeDTO> getAll();
}
