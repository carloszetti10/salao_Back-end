package com.carlos.salaoApi.service;


import com.carlos.salaoApi.model.Colaborador;
import com.carlos.salaoApi.model.Usuario;
import com.carlos.salaoApi.model.enumm.TipoUsuario;
import com.carlos.salaoApi.repository.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;
    private final UsuarioService usuarioService;

    @Transactional
    public Colaborador salvar(Usuario usuario){
        usuario.setTipoUsuario(TipoUsuario.COLABORADOR);
        Colaborador colaborador = new Colaborador();
        colaborador.setAtivo(true);
        colaborador.setUsuario(usuarioService.salvar(usuario));
        return repository.save(colaborador);
    }

}
