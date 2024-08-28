package com.products.cylontea.util.mapper;

import com.products.cylontea.dto.EmployeeDTO;
import com.products.cylontea.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    List<EmployeeDTO> employeeListToDtoList(List<Employee> employees);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);
}
