package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.model.Endereco;
import com.carlos.salaoApi.model.Salao;
import com.carlos.salaoApi.service.SalaoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("salao")
@RequiredArgsConstructor
public class SalaoController {

    private final SalaoService salaoService;

    @PostMapping
    public ResponseEntity<Object> salvarSalao(@RequestBody @Valid Salao salao){

        Salao salaoSalvo =  salaoService.salvar(salao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{nome}/{id}")
                .buildAndExpand(salaoSalvo.getNome(),salaoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
