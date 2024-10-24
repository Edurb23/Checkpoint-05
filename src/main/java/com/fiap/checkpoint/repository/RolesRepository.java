package com.fiap.checkpoint.repository;

import com.fiap.checkpoint.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {

    Role findByNome(String name);

}
