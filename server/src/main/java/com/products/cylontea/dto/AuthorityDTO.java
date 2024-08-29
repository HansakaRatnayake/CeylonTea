package com.products.cylontea.dto;

import com.products.cylontea.model.Module;
import com.products.cylontea.model.Operation;
import com.products.cylontea.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDTO {

    private Integer id;
    private Role role;
    private Module module;
    private Operation operation;
}
