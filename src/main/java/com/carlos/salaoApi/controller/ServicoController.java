package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.controller.common.exeption.MeuExeption;
import com.carlos.salaoApi.controller.dto.ServicoDTO;
import com.carlos.salaoApi.controller.common.erro.ErroResposta;
import com.carlos.salaoApi.controller.mappers.ServicoMapper;
import com.carlos.salaoApi.model.Servico;
import com.carlos.salaoApi.service.ServicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("servico")
@RequiredArgsConstructor
public class ServicoController {
    private final ServicoService service;
    private final ServicoMapper mapper = ServicoMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<Object> salvarServico(@RequestBody @Valid ServicoDTO dto){
            System.out.println(dto.toString());
            Servico servico = mapper.toEntity(dto);
            System.out.println(servico.toString());
            Servico servicoSalvo = service.salva(servico);
            URI location = URI.create("/servicos/" + servicoSalvo.getIdServico());
            return ResponseEntity.created(location).body(servicoSalvo);
    }


}
