package com.carlos.salaoApi.service;

import com.carlos.salaoApi.model.Cliente;
import com.carlos.salaoApi.model.Usuario;
import com.carlos.salaoApi.model.enumm.TipoUsuario;
import com.carlos.salaoApi.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;
    private final UsuarioService usuarioService;


    @Transactional
    public Cliente salvar(Usuario usuario){
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);
        Cliente cliente = new Cliente();
        cliente.setUsuario(usuarioService.salvar(usuario));
        return repository.save(cliente);
    }
}
