package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.UserStatusDTO;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Userstatus;
import com.products.cylontea.repository.UserStatusRepository;
import com.products.cylontea.service.UserStatusService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusServiceIMPL implements UserStatusService {

    private final UserStatusRepository userStatusRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<UserStatusDTO> getAll() {
        List<Userstatus> userStatusList = userStatusRepository.findAll();
        if(!userStatusList.isEmpty()){
            return objectMapper.userStatusListToDtoList(userStatusList);
        }else{
            throw new ResourceNotFoundException("UserStatus Not Found!");
        }
    }
}
