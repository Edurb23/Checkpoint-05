package com.fiap.checkpoint.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserForms {

    private String username;
    private String password;
    private List<String> roles;



}
