package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.controller.dto.AgendaDTO;
import com.carlos.salaoApi.controller.mappers.AgendaMapper;
import com.carlos.salaoApi.model.Agenda;
import com.carlos.salaoApi.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("agendas")
@RequiredArgsConstructor
public class AgendaController {
    private final AgendaService service;
    private  final AgendaMapper mapper;

    @PostMapping
    public Agenda salvarAgenda(@RequestBody Agenda agendaDTO){
       // Agenda agenda = mapper.toEntity(agendaDTO);
        return service.salvar(agendaDTO);
    }

    @GetMapping
    public List<Agenda> listarAgendas() {
        return service.listar();
    }
}
