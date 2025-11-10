package com.biblioteca.sistema_biblioteca.controller;


import com.biblioteca.sistema_biblioteca.dtos.ReqDtoLivro;
import com.biblioteca.sistema_biblioteca.models.ModelsLivros;
import com.biblioteca.sistema_biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {

    private LivroService livroService;

    @Autowired
    public  LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    @GetMapping("/buscar")
    public ResponseEntity<List<ModelsLivros>> buscarLivros(){
        return ResponseEntity.ok(livroService.bucarLivros());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ModelsLivros> cadastroLivro(@RequestBody ReqDtoLivro reqDtoLivro) {
        ModelsLivros cadastroLivro = livroService.casdastrarLivro(reqDtoLivro);

        return ResponseEntity.ok(cadastroLivro);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ModelsLivros> deletarLivro(@PathVariable Long id){

        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
