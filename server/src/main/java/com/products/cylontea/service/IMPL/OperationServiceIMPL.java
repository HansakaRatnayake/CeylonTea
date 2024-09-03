package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.OperationDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Operation;
import com.products.cylontea.repository.OperationRepository;
import com.products.cylontea.service.OperationService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationServiceIMPL implements OperationService {

    private final OperationRepository operationRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<OperationDTO> getAll() {
        List<Operation> operations = operationRepository.findAll();
        if(!operations.isEmpty()){
            return objectMapper.operationListToDtoList(operations);
        }else{
            throw new ResourceNotFoundException("No Operations Found!");
        }
    }
}
