package com.biblioteca.sistema_biblioteca.repository;

import com.biblioteca.sistema_biblioteca.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<Usuario,Long> {
}
