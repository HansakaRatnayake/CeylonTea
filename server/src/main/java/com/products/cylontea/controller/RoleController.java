package com.products.cylontea.controller;

import com.products.cylontea.dto.RoleDTO;
import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll(){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Received",roleService.getAll()), HttpStatus.OK
        );

    }
}
