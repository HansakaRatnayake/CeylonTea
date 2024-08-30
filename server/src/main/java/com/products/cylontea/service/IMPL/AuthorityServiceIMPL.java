package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.AuthorityDTO;
import com.products.cylontea.exception.ResourceAlreadyExistException;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.Authority;
import com.products.cylontea.repository.AuthorityRepository;
import com.products.cylontea.service.AuthorityService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AuthorityServiceIMPL implements AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<AuthorityDTO> getAll(HashMap<String, String> params) {
        List<Authority> authorities = authorityRepository.findAll();
        if(!authorities.isEmpty()){
            List<AuthorityDTO> dtos = objectMapper.authorityListToDtoList(authorities);

            if(params.isEmpty()){
                return dtos;
            }else{

                String roleid = params.get("roleid");
                String operationid = params.get("operationid");
                String moduleid = params.get("moduleid");

                Stream<AuthorityDTO> stream = dtos.stream();

                if(roleid != null) stream = stream.filter(e -> e.getRole().getId() == Integer.parseInt(roleid));
                if(operationid != null) stream = stream.filter(e -> e.getOperation().getId() == Integer.parseInt(operationid));
                if(moduleid != null) stream = stream.filter(e -> e.getModule().getId() == Integer.parseInt(moduleid));

                return stream.collect(Collectors.toList());
            }
        }else{
            throw new ResourceNotFoundException("Authority Not Found!");
        }
    }

    @Override
    public String create(AuthorityDTO authorityDTO) {

        if(authorityRepository.existsByRoleAndModuleAndOperation(authorityDTO.getRole(),authorityDTO.getModule(),authorityDTO.getOperation())){
            throw new ResourceAlreadyExistException("Authority Already Exists!");
        }

        Authority authority = objectMapper.authorityDtoToAuthority(authorityDTO);
        authorityRepository.save(authority);
        return "Authority Created!";
    }

    @Override
    public String update(AuthorityDTO authorityDTO) {

        Authority authorityrec = authorityRepository.findById(authorityDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Authority Not Found!"));

        if(authorityRepository.existsByRoleAndModuleAndOperation(authorityDTO.getRole(),authorityDTO.getModule(),authorityDTO.getOperation())){
            throw new ResourceAlreadyExistException("Authority Already Exists!");
        }

        Authority authority = objectMapper.authorityDtoToAuthority(authorityDTO);
        authorityRepository.save(authority);
        return "Authority Updated!";
    }

    @Override
    public String delete(Integer id) {
        Authority authority = authorityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Authority Not Found!"));

        authorityRepository.delete(authority);
        return "Authority Deleted!";
    }
}
