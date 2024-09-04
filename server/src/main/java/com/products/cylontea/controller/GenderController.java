package com.products.cylontea.controller;

import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.service.EmployeeTypeService;
import com.products.cylontea.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/genders")
@RestController
public class GenderController {

    private final GenderService genderService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll() {

        return new ResponseEntity<StandardResponse>(new StandardResponse(200, "Genders recieved", genderService.getAll()),
                HttpStatus.OK);

    }


}
