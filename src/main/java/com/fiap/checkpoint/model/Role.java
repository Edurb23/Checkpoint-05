package com.fiap.checkpoint.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_CP_JV_ROLES")
@Getter
@Setter
public class Role {


    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String label;

}
