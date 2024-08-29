package com.products.cylontea.service;

import com.products.cylontea.dto.AuthorityDTO;

import java.util.HashMap;
import java.util.List;

public interface AuthorityService {
    List<AuthorityDTO> getAll(HashMap<String, String> params);

    String create(AuthorityDTO authorityDTO);

    String update(AuthorityDTO authorityDTO);

    String delete(Integer id);
}
