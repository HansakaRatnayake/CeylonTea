package com.products.cylontea.controller;

import com.products.cylontea.dto.AuthorityDTO;
import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authorities")
public class AuthorityController {

    private final AuthorityService authorityService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll(@RequestParam HashMap<String, String> params) {
        List<AuthorityDTO> list = authorityService.getAll(params);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Received Successfully",list), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody AuthorityDTO authorityDTO) {
        String message = authorityService.create(authorityDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Created Successfully",message), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> update(@RequestBody AuthorityDTO authorityDTO) {
        String message = authorityService.update(authorityDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Updated Successfully",message), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable Integer id) {
        String message = authorityService.delete(id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Deleted Successfully",message), HttpStatus.OK
        );
    }
}
