package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.RoleDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Role;
import com.products.cylontea.repository.RoleRepository;
import com.products.cylontea.service.RoleService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceIMPL implements RoleService {

    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<RoleDTO> getAll() {
        List<Role> roles = roleRepository.findAll();
        if(!roles.isEmpty()) {
            return objectMapper.roleListToDtoList(roles);
        }else{
            throw new ResourceNotFoundException("Roles Not Found!");
        }
    }
}
