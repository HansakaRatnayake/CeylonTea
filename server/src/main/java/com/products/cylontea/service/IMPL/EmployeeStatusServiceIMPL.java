package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.EmployeeStatusDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Employeestatus;
import com.products.cylontea.repository.EmployeeStatusRepository;
import com.products.cylontea.service.EmployeeStatusService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeStatusServiceIMPL implements EmployeeStatusService {

    private final EmployeeStatusRepository employeeStatusRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<EmployeeStatusDTO> getAll() {

        List<Employeestatus> employeestatusList = employeeStatusRepository.findAll();

        if (!employeestatusList.isEmpty()) return objectMapper.employeeStatusListToDtoList(employeestatusList);
        else throw new ResourceNotFoundException("Employee status list is empty");

    }
}
