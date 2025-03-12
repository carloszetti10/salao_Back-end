package com.carlos.salaoApi.validator;


import com.carlos.salaoApi.controller.common.exeption.MeuExeption;
import com.carlos.salaoApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component

public class UsuarioValidator {

    @Autowired
    UsuarioRepository repository;

    public void validarEmail(String email){
        if (repository.findByEmail(email).isPresent()){
            throw new MeuExeption("Email já cadastrado!");
        }
    }

}

