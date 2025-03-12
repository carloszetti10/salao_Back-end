package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.controller.erro.ErroResposta;
import com.carlos.salaoApi.exceptions.MeusExeption;
import com.carlos.salaoApi.model.Cliente;
import com.carlos.salaoApi.model.Colaborador;
import com.carlos.salaoApi.model.Usuario;

import com.carlos.salaoApi.service.ClienteService;
import com.carlos.salaoApi.service.ColaboradorService;
import com.carlos.salaoApi.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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


    @PostMapping("/cliente")
    public ResponseEntity<Object> salvarCliente(@RequestBody @Valid Usuario usuario){
        try {
            Cliente clieteSalvo = clienteService.salvar(usuario);
            return ResponseEntity.ok(clieteSalvo);
        } catch (MeusExeption e) {
            var erroDto = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }

    @PostMapping("/colaborador")
    public ResponseEntity<Object> salvarColaborador(@RequestBody @Valid Usuario usuario){
        try {
            Colaborador colabSalvo = colaboradorService.salvar(usuario);
            return ResponseEntity.ok(colabSalvo);
        }catch (MeusExeption e){
            var erroDto = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }

    }





}
