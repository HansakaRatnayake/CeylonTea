package com.products.cylontea.service;


import com.products.cylontea.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {


    List<UserDTO> getAll(Map<String, String> params);

    List<UserDTO> getAllList(Map<String, String> params);

    String create(UserDTO userDTO);

    String update(UserDTO userDTO);

    String delete(Integer id);
}
