package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.dtos.ReqDtoLivro;
import com.biblioteca.sistema_biblioteca.models.ModelsLivros;
import com.biblioteca.sistema_biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public ModelsLivros casdastrarLivro(ReqDtoLivro reqDtoLivro){

        ModelsLivros modelsLivro = new ModelsLivros();

        modelsLivro.setTitulor(reqDtoLivro.getTitulo());
        modelsLivro.setTitulor(reqDtoLivro.getTitulo());
        modelsLivro.setAutor(reqDtoLivro.getAutor());
        modelsLivro.setCategoria(reqDtoLivro.getCategoria());
        modelsLivro.setAnoPublic(reqDtoLivro.getAnoPublic());

        return livroRepository.save(modelsLivro);
    }

    public List<ModelsLivros> bucarLivros(){
        return livroRepository.findAll();
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

}
