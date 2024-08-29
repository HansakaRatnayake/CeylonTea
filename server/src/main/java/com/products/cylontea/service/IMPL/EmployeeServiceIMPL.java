package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.EmployeeDTO;
import com.products.cylontea.exception.ResourceAlreadyExistException;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Employee;
import com.products.cylontea.repository.EmployeeRepository;
import com.products.cylontea.service.EmployeeService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {

    private final ObjectMapper objectMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAll(@RequestParam HashMap<String, String> params) {
        List<Employee> employees = employeeRepository.findAll();
        if(!employees.isEmpty()){
            List<EmployeeDTO> dtos = objectMapper.employeeListToDtoList(employees);

            if(params.isEmpty()){
                return dtos;
            }else{
                String firstname = params.get("firstname");
                String number = params.get("number");
                String employeestatusid = params.get("employeestatusid");
                String nic = params.get("nic");

                Stream<EmployeeDTO> estream = dtos.stream();

                if(firstname != null) estream = estream.filter(e -> e.getFirstname().contains(firstname));
                if(number != null) estream = estream.filter(e -> e.getNumber().equals(number));
                if(nic != null) estream = estream.filter(e -> e.getNic().equals(nic));
                if(employeestatusid != null) estream = estream.filter(e -> e.getEmployeestatus().getId() == Integer.parseInt(employeestatusid));

                return estream.collect(Collectors.toList());

            }
        }else{
            throw new ResourceNotFoundException("Employee Not Found!");
        }
    }

    @Override
    public String create(EmployeeDTO employeeDTO) {

        if(employeeRepository.existsByNumber(employeeDTO.getNumber())){
            throw new ResourceAlreadyExistException("Number Already Exists!");
        }

        if(employeeRepository.existsByNic(employeeDTO.getNic())){
            throw new ResourceAlreadyExistException("Nic Already Exists!");
        }

        if(employeeRepository.existsByMobile(employeeDTO.getMobile())){
            throw new ResourceAlreadyExistException("Mobile No Already Exists!");
        }

        Employee employee = objectMapper.employeeDtoToEmployee(employeeDTO);
        employeeRepository.save(employee);
        return "Employee Saved Successfully!";
    }

    @Override
    public String update(EmployeeDTO employeeDTO) {

        Employee employeerec = employeeRepository.findById(employeeDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found!"));

        if(!employeerec.getMobile().equals(employeeDTO.getMobile()) && employeeRepository.existsByMobile(employeeDTO.getMobile())){
            throw new ResourceAlreadyExistException("Mobile Already Exists!");
        }

        if(!employeerec.getNic().equals(employeeDTO.getNic()) && employeeRepository.existsByNic(employeeDTO.getNic())){
            throw new ResourceAlreadyExistException("Nic Already Exists!");
        }

        if(!employeerec.getNumber().equals(employeeDTO.getNumber()) && employeeRepository.existsByNumber(employeeDTO.getNumber())){
            throw new ResourceAlreadyExistException("Number Already Exists!");
        }

        Employee employee = objectMapper.employeeDtoToEmployee(employeeDTO);
        employeeRepository.save(employee);
        return "Employee Updated Successfully!";


    }

    @Override
    public String delete(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found!"));
        employeeRepository.delete(employee);
        return "Employee Deleted Successfully!";
    }

    @Override
    public List<EmployeeDTO> getAllList(HashMap<String, String> params) {
        List<Employee> employees = employeeRepository.findAll();
        if(!employees.isEmpty()){
            List<EmployeeDTO> dtos = objectMapper.employeeListToDtoList(employees);

            dtos = dtos.stream().map(
                    e -> {
                        EmployeeDTO dto = new EmployeeDTO(e.getId(),e.getFirstname(),e.getLastname(),e.getNumber(),e.getGender(),e.getDesignation(),e.getEmployeestatus(),e.getEmployeetype());
                        return dto;
                    }
            ).collect(Collectors.toList());

            if(params.isEmpty()){
                return dtos;
            }else{
                String firstname = params.get("firstname");
                String number = params.get("number");
                String employeestatusid = params.get("employeestatusid");
                String nic = params.get("nic");

                Stream<EmployeeDTO> estream = dtos.stream();

                if(firstname != null) estream = estream.filter(e -> e.getFirstname().contains(firstname));
                if(number != null) estream = estream.filter(e -> e.getNumber().equals(number));
                if(nic != null) estream = estream.filter(e -> e.getNic().equals(nic));
                if(employeestatusid != null) estream = estream.filter(e -> e.getEmployeestatus().getId() == Integer.parseInt(employeestatusid));

                return estream.collect(Collectors.toList());

            }
        }else{
            throw new ResourceNotFoundException("Employee Not Found!");
        }
    }
}
