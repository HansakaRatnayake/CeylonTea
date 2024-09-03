package com.products.cylontea.controller;


import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.dto.UserDTO;
import com.products.cylontea.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll(@RequestParam Map<String, String> params) {
      List<UserDTO> userDTOList= userService.getAll(params);
      return new ResponseEntity<StandardResponse>(
              new StandardResponse(200,"Users Successfully Recived",userDTOList),
              HttpStatus.OK
      );

    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllList(@RequestParam Map<String, String> params) {
        List<UserDTO> userDTOList = userService.getAllList(params);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Users Successfully Recived",userDTOList),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody UserDTO userDTO) {
          String message = userService.create(userDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"User Successfully Created",message),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> update(@RequestBody UserDTO userDTO) {
        String message = userService.update(userDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"User Successfully Updated",message),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable Integer id) {
        String message = userService.delete(id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"User Successfully Deleted",message),
                HttpStatus.CREATED
        );
    }



}
