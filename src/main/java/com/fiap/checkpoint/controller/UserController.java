package com.fiap.checkpoint.controller;

import com.fiap.checkpoint.model.UserForms;
import com.fiap.checkpoint.service.PassEncoder;
import com.fiap.checkpoint.service.UsuarioService;
import com.fiap.checkpoint.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PassEncoder passEncoder;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForms());
        model.addAttribute("roles", rolesRepository.findAll());
        return "register";
    }



}
