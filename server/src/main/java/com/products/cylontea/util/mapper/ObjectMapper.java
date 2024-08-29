package com.products.cylontea.util.mapper;


import com.products.cylontea.dto.EmployeeDTO;
import com.products.cylontea.dto.UserDTO;
import com.products.cylontea.model.Employee;
import com.products.cylontea.model.User;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ObjectMapper {


    List<EmployeeDTO> employeeListToDtoList(List<Employee> employees);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);

    List<UserDTO> userListToDtoList(List<User> userList);

    User userDtoToUser(UserDTO userDTO);
}
