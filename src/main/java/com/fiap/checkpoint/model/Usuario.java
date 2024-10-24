package com.fiap.checkpoint.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "TB_CP_JV_USER")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;


    //Relação

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_CP_JV_USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> roles;
}



