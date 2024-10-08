package com.products.cylontea.util.mapper;


import com.products.cylontea.dto.*;
import com.products.cylontea.model.*;
import com.products.cylontea.model.Module;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ObjectMapper {


    List<EmployeeDTO> employeeListToDtoList(List<Employee> employees);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);

    List<UserDTO> userListToDtoList(List<User> userList);

    User userDtoToUser(UserDTO userDTO);

    List<AuthorityDTO> authorityListToDtoList(List<Authority> authorities);

    Authority authorityDtoToAuthority(AuthorityDTO authorityDTO);

    List<EmployeeStatusDTO> employeeStatusListToDtoList(List<Employeestatus> employeestatusList);

    List<EmployeeTypeDTO> employeeTypeListToDtoList(List<Employeetype> employeetypeList);

    List<DesignationDTO> designationListToDtoList(List<Designation> designationList);

    List<GenderDTO> genderListToDtoList(List<Gender> genderList);

    List<ModuleDTO> moduleListToDtoList(List<Module> modules);

    List<OperationDTO> operationListToDtoList(List<Operation> operations);

    List<RoleDTO> roleListToDtoList(List<Role> roles);

    List<UserStatusDTO> userStatusListToDtoList(List<Userstatus> userStatusList);

    List<UserTypeDTO> userTypeListToDtoList(List<Usertype> userTypes);
}
