package com.biblioteca.sistema_biblioteca.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqDtoLivro {

    private String titulo;
    private String autor;
    private String categoria;
    private Integer anoPublic;
}
