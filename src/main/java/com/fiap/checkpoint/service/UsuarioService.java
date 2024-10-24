package com.fiap.checkpoint.service;

import com.fiap.checkpoint.model.Role;
import com.fiap.checkpoint.model.Usuario;
import com.fiap.checkpoint.repository.RolesRepository;
import com.fiap.checkpoint.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.List;

public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private RolesRepository roleRepository;




    public void saveUser(String username, String password, List<String> roles) {
        Usuario user = new Usuario();
        user.setUsername(username);
        user.setPassword(password);

        HashSet<Role> userRoles = new HashSet<>();
        for (String roleName : roles) {
            Role role = roleRepository.findByNome(roleName);
            if (role != null) {
                userRoles.add(role);
            }
        }
        user.setRoles(userRoles);
        repository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        return null;
    }


}
