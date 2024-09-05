package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.UserTypeDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Usertype;
import com.products.cylontea.repository.UserTypeRepository;
import com.products.cylontea.service.UserTypeService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTypeServiceIMPL implements UserTypeService {

    private final UserTypeRepository userTypeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<UserTypeDTO> getAll() {
        List<Usertype> userTypes = userTypeRepository.findAll();
        if(!userTypes.isEmpty()){
            return objectMapper.userTypeListToDtoList(userTypes);
        }else{
            throw new ResourceNotFoundException("UserType Not Found!");
        }

    }
}
