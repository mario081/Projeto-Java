package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.models.Usuario;
import com.biblioteca.sistema_biblioteca.repository.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //Construtor
    private final UserRepositry userRepositry;

    @Autowired
    public UserService(UserRepositry userRepositry){
        this.userRepositry=userRepositry;
    }

    //Chamada para chamar todos os usuarios
    public List<Usuario> buscarUsuarios(){
        return userRepositry.findAll();
    }

}
