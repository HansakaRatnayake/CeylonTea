package com.products.cylontea.controller;

import com.products.cylontea.dto.EmployeeDTO;
import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll(@RequestParam HashMap<String, String> params) {
        List<EmployeeDTO> dtoList = employeeService.getAll(params);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Received", dtoList), HttpStatus.OK
        );
    }

    @GetMapping(path = "/list")
    public ResponseEntity<StandardResponse> getAllList(@RequestParam HashMap<String, String> params) {
        List<EmployeeDTO> dtoList = employeeService.getAllList(params);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Received", dtoList), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody EmployeeDTO employeeDTO) {
        String message = employeeService.create(employeeDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", message), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> update(@RequestBody EmployeeDTO employeeDTO) {
        String message = employeeService.update(employeeDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Updated", message), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable Integer id) {
        String message = employeeService.delete(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Successfully Updated", message), HttpStatus.OK
        );
    }
}
