package com.carlos.salaoApi.service;

import com.carlos.salaoApi.model.Usuario;
import com.carlos.salaoApi.repository.UsuarioRepository;
import com.carlos.salaoApi.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service()
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator validator;

    public Usuario salvar(Usuario usuario){
        validator.validarEmail(usuario.getEmail());
        return usuarioRepository.save(usuario);
    }
}
