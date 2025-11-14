package com.biblioteca.sistema_biblioteca.controller;


import com.biblioteca.sistema_biblioteca.dtos.ReqDtoLivro;
import com.biblioteca.sistema_biblioteca.models.ModelsLivros;
import com.biblioteca.sistema_biblioteca.service.LivroService;
import com.biblioteca.sistema_biblioteca.utils.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("livro")
public class LivroController {

    private final LivroService livroService;

    @GetMapping("/buscar")
    public ResponseEntity<List<ModelsLivros>> buscarLivros(){
        return ResponseEntity.ok(livroService.buscarLivros());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastroLivro(@RequestBody List<ReqDtoLivro> reqDtoLivro) {
        CommonResponse<?> cadastroLivro = livroService.cadastrarLivro(reqDtoLivro);

        return ResponseEntity.status(cadastroLivro.getStatus()).body(cadastroLivro);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarLivro(@PathVariable Long id, @RequestBody ReqDtoLivro reqDtoLivro) {

    CommonResponse<?> livroAtualizado = livroService.atualizarLivros(id, reqDtoLivro);

    return ResponseEntity.status(livroAtualizado.getStatus()).body(livroAtualizado);
}

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ModelsLivros> deletarLivro(@PathVariable Long id){

        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
