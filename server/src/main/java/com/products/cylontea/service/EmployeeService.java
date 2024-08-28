package com.products.cylontea.service;

import com.products.cylontea.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAll(@RequestParam HashMap<String, String> params);

    String create(EmployeeDTO employeeDTO);

    String update(EmployeeDTO employeeDTO);

    String delete(Integer id);

    List<EmployeeDTO> getAllList(HashMap<String, String> params);
}
