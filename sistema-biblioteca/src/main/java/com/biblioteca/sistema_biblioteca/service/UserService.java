package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.dtos.UserDto;
import com.biblioteca.sistema_biblioteca.models.Usuario;
import com.biblioteca.sistema_biblioteca.repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositry userRepositry;
    private final PasswordEncoder passwordEncoder;

    public Usuario cadastrar(UserDto userDto){

        Usuario usuario = new Usuario();
        usuario.setName(userDto.getName());
        usuario.setEmail(userDto.getEmail());

        String passwordHash = passwordEncoder.encode(userDto.getPassword());

        usuario.setPassword(passwordHash);

        return userRepositry.save(usuario);
    }

    //Chamada para chamar todos os usuarios
    public List<Usuario> buscarUsuarios(){
        return userRepositry.findAll();
    }

    //Chamada para deletar os usuario
    public void deletar(Long id){
        userRepositry.deleteById(id);
    }

}
