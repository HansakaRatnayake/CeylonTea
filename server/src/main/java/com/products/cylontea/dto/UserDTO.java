package com.products.cylontea.dto;

import com.products.cylontea.model.Employee;
import com.products.cylontea.model.Role;
import com.products.cylontea.model.Userstatus;
import com.products.cylontea.model.Usertype;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{

    private Integer id;
    private String username;
    private String password;
    private String description;
    private Userstatus userstatus;
    private Usertype usertype;
    private Employee employee;
    private Set<Role> roles = new LinkedHashSet<>();

    public UserDTO(String username, String password, Userstatus userstatus, Employee employee) {
        this.username = username;
        this.password = password;
        this.userstatus = userstatus;
        this.employee = employee;
    }



}
