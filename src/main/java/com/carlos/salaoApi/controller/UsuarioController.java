package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.controller.common.exeption.MeuExeption;
import com.carlos.salaoApi.controller.dto.UsuarioDTO;
import com.carlos.salaoApi.controller.common.erro.ErroResposta;
import com.carlos.salaoApi.controller.mappers.UsuarioMapper;
import com.carlos.salaoApi.model.Cliente;
import com.carlos.salaoApi.model.Colaborador;

import com.carlos.salaoApi.service.ClienteService;
import com.carlos.salaoApi.service.ColaboradorService;
import com.carlos.salaoApi.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final ClienteService clienteService;
    private final ColaboradorService colaboradorService;

    @Autowired
    UsuarioMapper mapper;

    @PostMapping("/cliente")
    public ResponseEntity<Object> salvarCliente(@RequestBody @Valid UsuarioDTO dto){
        try {
            Cliente clieteSalvo = clienteService.salvar(mapper.toEntity(dto));
            return ResponseEntity.ok(clieteSalvo);
        } catch (MeuExeption e) {
            var erroDto = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }

    @PostMapping("/colaborador")
    public ResponseEntity<Object> salvarColaborador(@RequestBody @Valid UsuarioDTO dto){
        try {
            Colaborador colabSalvo = colaboradorService.salvar(mapper.toEntity(dto));
            return ResponseEntity.ok(colabSalvo);
        }catch (MeuExeption e){
            var erroDto = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }

    }





}
