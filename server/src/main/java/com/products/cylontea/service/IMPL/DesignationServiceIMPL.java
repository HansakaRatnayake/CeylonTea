package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.DesignationDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Designation;
import com.products.cylontea.repository.DesignationRepository;
import com.products.cylontea.service.DesignationService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignationServiceIMPL implements DesignationService {

    private final DesignationRepository designationRepository;
    private final ObjectMapper objectMapper;


    @Override
    public List<DesignationDTO> getAll() {
        List<Designation> designationList = designationRepository.findAll();

        if (!designationList.isEmpty()) return objectMapper.designationListToDtoList(designationList);
        else throw new ResourceNotFoundException("Designation list is empty");
    }
}
