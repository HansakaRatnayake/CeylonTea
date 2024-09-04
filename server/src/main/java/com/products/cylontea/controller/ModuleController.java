package com.products.cylontea.controller;

import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/modules")
@RestController
public class ModuleController {

    private final ModuleService moduleService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll() {
        return new ResponseEntity<StandardResponse>(new StandardResponse(200, "Designations recieved", moduleService.getAll()),
                HttpStatus.OK);

    }


}
