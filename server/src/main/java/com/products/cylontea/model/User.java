package com.products.cylontea.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "username")
    private String username;

    @Lob
    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne( optional = false)
    @JoinColumn(name = "userstatus_id", nullable = false)
    private Userstatus userstatus;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "usertype_id", nullable = false)
    private Usertype usertype;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToMany()
    @JoinTable(name = "usersrole",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new LinkedHashSet<>();

}