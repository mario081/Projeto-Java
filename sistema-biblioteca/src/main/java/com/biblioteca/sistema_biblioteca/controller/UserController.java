package com.biblioteca.sistema_biblioteca.controller;


import com.biblioteca.sistema_biblioteca.models.Usuario;
import com.biblioteca.sistema_biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/buscar")
    @GetMapping
    public ResponseEntity<List<Usuario>> buscartodos(){
        return ResponseEntity.ok(userService.buscarUsuarios());
    }

}
