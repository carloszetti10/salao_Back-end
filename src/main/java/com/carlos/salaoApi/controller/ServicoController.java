package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.controller.dto.ServicoDTO;
import com.carlos.salaoApi.model.Servico;
import com.carlos.salaoApi.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("servicos")
@RequiredArgsConstructor
public class ServicoController {
    private final ServicoService service;

    @PostMapping
    public ResponseEntity<Object> salvarServico(@RequestBody ServicoDTO servicoDTO){
        Servico servico = servicoDTO.mapearServivo();
        Servico servicoSalvo = service.salva(servico);
        URI location = URI.create("/servicos/" + servicoSalvo.getIdServico());
        return ResponseEntity.created(location).body(servicoSalvo);

    }


}
