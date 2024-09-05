package com.products.cylontea.controller;

import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.dto.UserStatusDTO;
import com.products.cylontea.service.UserStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userstatuses")
@RequiredArgsConstructor
public class UserStatusController {

    private final UserStatusService userStatusService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll(){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Received",userStatusService.getAll()), HttpStatus.OK
        );
    }
}
