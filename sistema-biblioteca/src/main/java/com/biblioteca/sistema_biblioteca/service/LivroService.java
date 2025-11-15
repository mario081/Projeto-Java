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

    public CommonResponse<?> buscarLivros(){
        List<ModelsLivros> livros = livroRepository.findAll();


        if(livros.isEmpty()){
            return CommonResponse.success("Nenhum livro encontrado na base de dados.", livros);
        }

        return  CommonResponse.success("Busca de livros realizada com sucesso.", livros);
    }


    public CommonResponse<?> atualizarLivros(Long id, ReqDtoLivro reqDtoLivro){

          ModelsLivros livroExistente = livroRepository.findById(id)
                  .orElseThrow(()-> new ResourceNotFoundException("Livro não encontrado com o Id " + id));

            livroExistente.setTitulo(reqDtoLivro.getTitulo());
            livroExistente.setAutor(reqDtoLivro.getAutor());
            livroExistente.setCategoria(reqDtoLivro.getCategoria());
            livroExistente.setAnoPublic(reqDtoLivro.getAnoPublic());

          return CommonResponse.updated(livroRepository.save(livroExistente));
    }

    public CommonResponse<?> deletar(Long id){

        if(!livroRepository.existsById(id)){
            throw new ResourceNotFoundException("Livro com ID " + id + " não encontrado para deleção.");
        }
        livroRepository.deleteById(id);

        return CommonResponse.deleted("Livro deletado com sucesso!");
    }
}
