package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.controller.dto.SalaoDTO;
import com.carlos.salaoApi.controller.mappers.SalaoMapper;
import com.carlos.salaoApi.model.Salao;
import com.carlos.salaoApi.service.SalaoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("salao")
@RequiredArgsConstructor
public class SalaoController {

    private final SalaoService salaoService;
    private final SalaoMapper mapper = SalaoMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<Object> salvarSalao(@RequestBody @Valid SalaoDTO dto){

        Salao salao = mapper.toEntity(dto);
        Salao salaoSalvo =  salaoService.salvar(salao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{nome}/{id}")
                .buildAndExpand(salaoSalvo.getNome(),salaoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(salaoSalvo);
    }
}
