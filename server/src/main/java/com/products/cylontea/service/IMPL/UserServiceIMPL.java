package com.products.cylontea.service.IMPL;

import com.products.cylontea.dto.UserDTO;
import com.products.cylontea.exception.ResourceAlreadyExistException;
import com.products.cylontea.exception.ResourceNotFoundException;
import com.products.cylontea.model.User;
import com.products.cylontea.repository.UserRepository;
import com.products.cylontea.service.UserService;
import com.products.cylontea.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAll(Map<String, String> params) {
        List<User> userList = userRepository.findAll();

        if (!userList.isEmpty()) {
            List<UserDTO> userDTOList = objectMapper.userListToDtoList(userList);

            if (params.isEmpty()) {
                return userDTOList;
            } else {

                String username = params.get("username");
                String userstatusid = params.get("userstatusid");
                String roleid = params.get("roleid");
                String employeeid = params.get("employeeid");

                Stream<UserDTO> stream = userDTOList.stream();

                if (username != null) stream = stream.filter(u -> u.getUsername().equals(username));
                if (userstatusid != null) stream = stream.filter(u -> u.getUserstatus().getId() == Integer.parseInt(userstatusid) );
                if (roleid != null) stream = stream.filter(u -> u.getRoles().stream().anyMatch(r -> r.getId() == Integer.parseInt(roleid)));
                if (employeeid != null) stream = stream.filter(u -> u.getId() == Integer.parseInt(employeeid));

                return stream.collect(Collectors.toList());

            }

        }  else {
            throw new ResourceNotFoundException("Users Not Found");
        }

    }

    @Override
    public List<UserDTO> getAllList(Map<String, String> params) {
        List<User> userList = userRepository.findAll();

        if (!userList.isEmpty()) {
            List<UserDTO> userDTOList = objectMapper.userListToDtoList(userList);

            userDTOList = userDTOList.stream().map(
                    u -> new UserDTO(u.getUsername(),u.getPassword(),u.getUserstatus(),
                    u.getEmployee())).collect(Collectors.toList()
            );


            if (params.isEmpty()){
                return userDTOList;
            }else {
                String username = params.get("username");
                String userstatusid = params.get("userstatusid");
                String roleid = params.get("roleid");
                String employeeid = params.get("employeeid");

                Stream<UserDTO> stream = userDTOList.stream();

                if (username != null) stream = stream.filter(u -> u.getUsername().equals(username));
                if (userstatusid != null) stream = stream.filter(u -> u.getUserstatus().getId() == Integer.parseInt(userstatusid) );
                if (roleid != null) stream = stream.filter(u -> u.getRoles().stream().anyMatch(r -> r.getId() == Integer.parseInt(roleid)));
                if (employeeid != null) stream = stream.filter(u -> u.getId() == Integer.parseInt(employeeid));

                return stream.collect(Collectors.toList());
            }


        }else {
            throw new ResourceNotFoundException("Users Not Found");
        }


    }

    @Override
    public String create(UserDTO userDTO) {

        if (userRepository.existsByUsername(userDTO.getUsername())) throw new ResourceAlreadyExistException("Username already existes");

        User user = objectMapper.userDtoToUser(userDTO);

        userRepository.save(user);

        return "Saved";
    }

    @Override
    public String update(UserDTO userDTO) {

        User selecteduser = userRepository.findById(userDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        if (userRepository.existsByUsername(userDTO.getUsername()) && !userDTO.getUsername().equals(selecteduser.getUsername()) )
            throw new ResourceAlreadyExistException("Username already existes");


        User user = objectMapper.userDtoToUser(userDTO);
        userRepository.save(user);

        return "Updated";

    }

    @Override
    public String delete(Integer id) {

        User selecteduser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        userRepository.delete(selecteduser);

        return "Deleted";
    }
}
