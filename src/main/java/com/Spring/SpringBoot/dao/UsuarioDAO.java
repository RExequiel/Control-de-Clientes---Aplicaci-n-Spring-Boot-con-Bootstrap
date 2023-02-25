package com.Spring.SpringBoot.dao;

import com.Spring.SpringBoot.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
