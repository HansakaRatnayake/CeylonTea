package com.products.cylontea.controller;

import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.service.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/usertypes")
@RequiredArgsConstructor
public class UserTypeController {

    private final UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll(){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Received",userTypeService.getAll()), HttpStatus.OK
        );
    }
}
