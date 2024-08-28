package com.products.cylontea.dto;

import com.products.cylontea.model.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Integer id;
    private String firstname;
    private String lastname;
    private String number;
    private String nic;
    private String mobile;
    private String land;
    private String address;
    private LocalDate doregistered;
    private LocalDate dob;
    private Gender gender;
    private Designation designation;
    private Employeestatus employeestatus;
    private Employeetype employeetype;

    public EmployeeDTO(Integer id,String firstname,String lastname,String number,Gender gender,Designation designation,Employeestatus employeestatus,Employeetype employeetype) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
        this.gender = gender;
        this.designation = designation;
        this.employeestatus = employeestatus;
        this.employeetype = employeetype;
    }
}
