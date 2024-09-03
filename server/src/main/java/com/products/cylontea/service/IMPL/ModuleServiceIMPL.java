package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.ModuleDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Module;
import com.products.cylontea.repository.ModuleRepository;
import com.products.cylontea.service.ModuleService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceIMPL implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<ModuleDTO> getAll() {
        List<Module> modules = moduleRepository.findAll();
        if(!modules.isEmpty()) {
            return objectMapper.moduleListToDtoList(modules);
        }else{
            throw new ResourceNotFoundException("Modules Not Found!");
        }
    }
}
