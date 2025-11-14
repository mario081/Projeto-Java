package com.biblioteca.sistema_biblioteca.controller;


import com.biblioteca.sistema_biblioteca.dtos.UserDto;
import com.biblioteca.sistema_biblioteca.models.Usuario;
import com.biblioteca.sistema_biblioteca.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UserController {

    private final UserService userService;

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody UserDto userDto){
        Usuario usuarioSalvo = userService.cadastrar(userDto);

        return ResponseEntity.ok(usuarioSalvo);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> buscartodos(){
        return ResponseEntity.ok(userService.buscarUsuarios());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long id){

        userService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
