package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.EmployeeTypeDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Employeetype;
import com.products.cylontea.repository.EmployeeTypeRepository;
import com.products.cylontea.service.EmployeeTypeService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeTypeServiceIMPL implements EmployeeTypeService {

    private final EmployeeTypeRepository employeeTypeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<EmployeeTypeDTO> getAll() {

        List<Employeetype> employeetypeList = employeeTypeRepository.findAll();

        if (!employeetypeList.isEmpty()) return objectMapper.employeeTypeListToDtoList(employeetypeList);
        else throw new ResourceNotFoundException("Employee Type Not Found");

    }
}
