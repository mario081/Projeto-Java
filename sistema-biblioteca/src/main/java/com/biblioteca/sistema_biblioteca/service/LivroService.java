package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.dtos.ReqDtoLivro;
import com.biblioteca.sistema_biblioteca.exceptions.ResourceNotFoundException;
import com.biblioteca.sistema_biblioteca.models.ModelsLivros;
import com.biblioteca.sistema_biblioteca.repository.LivroRepository;
import com.biblioteca.sistema_biblioteca.utils.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public CommonResponse<?> cadastrarLivro(List<ReqDtoLivro> reqDtoLivro){

        List<ModelsLivros> modelsLivro = new ArrayList<>();

        for(ReqDtoLivro livro : reqDtoLivro){
            ModelsLivros modelsLivros = new ModelsLivros();

            modelsLivros.setTitulo(livro.getTitulo());
            modelsLivros.setAutor(livro.getAutor());
            modelsLivros.setCategoria(livro.getCategoria());
            modelsLivros.setAnoPublic(livro.getAnoPublic());

            modelsLivro.add(modelsLivros);

        }

        return CommonResponse.created(livroRepository.saveAll(modelsLivro));
    }

    public List<ModelsLivros> buscarLivros(){
        return livroRepository.findAll();
    }


    public CommonResponse<?> atualizarLivros(Long id, ReqDtoLivro reqDtoLivro){
      try {
          Optional<ModelsLivros> livroExistente = livroRepository.findById(id);

          if (livroExistente.isEmpty()) {
              log.info("entrou no if");
              throw new ResourceNotFoundException("Livro não encontrado com o Id" + id);
          }
          ModelsLivros livro = livroExistente.get();

          livro.setTitulo(reqDtoLivro.getTitulo());
          livro.setAutor(reqDtoLivro.getAutor());
          livro.setCategoria(reqDtoLivro.getCategoria());
          livro.setAnoPublic(reqDtoLivro.getAnoPublic());

          return CommonResponse.updated(livroRepository.save(livro));
      }catch (Exception e){
          return CommonResponse.convertThrowableToCommonResponse(e);
      }
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

}
