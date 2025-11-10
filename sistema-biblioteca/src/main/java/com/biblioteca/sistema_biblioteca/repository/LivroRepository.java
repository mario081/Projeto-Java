package com.biblioteca.sistema_biblioteca.repository;

import com.biblioteca.sistema_biblioteca.models.ModelsLivros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<ModelsLivros, Long> {
}
