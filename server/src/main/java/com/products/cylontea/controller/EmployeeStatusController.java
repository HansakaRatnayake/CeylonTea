package com.products.cylontea.controller;

import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.service.EmployeeStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employeestatuses")
public class EmployeeStatusController {

    private final EmployeeStatusService employeeStatusService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll() {

        return new ResponseEntity<StandardResponse>(new StandardResponse(200, "Employee Status recieved", employeeStatusService.getAll()),
                HttpStatus.OK);

    }


}
