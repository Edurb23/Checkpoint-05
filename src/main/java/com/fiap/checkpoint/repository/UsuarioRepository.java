package com.fiap.checkpoint.repository;

import com.fiap.checkpoint.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);


}
