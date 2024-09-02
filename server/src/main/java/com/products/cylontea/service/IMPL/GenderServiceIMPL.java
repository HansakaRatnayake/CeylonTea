package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.GenderDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Gender;
import com.products.cylontea.repository.GenderRepository;
import com.products.cylontea.service.GenderService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GenderServiceIMPL implements GenderService {

    private final GenderRepository genderRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<GenderDTO> getAll() {
        List<Gender> genderList = genderRepository.findAll();

        if (!genderList.isEmpty()) return objectMapper.genderListToDtoList(genderList);
        else throw new ResourceNotFoundException("Gender not found");
    }
}
