package com.products.cylontea.controller;

import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.service.EmployeeStatusService;
import com.products.cylontea.service.EmployeeTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/v1/employeetypes")
public class EmployeeTypeController {

    private final EmployeeTypeService employeeTypeService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll() {

        return new ResponseEntity<StandardResponse>(new StandardResponse(200, "Employee types recieved", employeeTypeService.getAll()),
                HttpStatus.OK);

    }


}
