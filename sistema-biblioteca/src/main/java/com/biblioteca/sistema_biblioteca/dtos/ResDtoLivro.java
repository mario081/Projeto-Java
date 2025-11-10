package com.biblioteca.sistema_biblioteca.dtos;

import com.biblioteca.sistema_biblioteca.models.ModelsLivros;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResDtoLivro {

    private long id;
    private String titulo;
    private String categoria;
    private String autor;
    private Integer anoPublic;

    public ResDtoLivro(ModelsLivros livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulor();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
        this.anoPublic = livro.getAnoPublic();
    }
}
