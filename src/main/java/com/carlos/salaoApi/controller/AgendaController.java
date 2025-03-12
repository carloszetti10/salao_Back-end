package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.controller.common.erro.ErroResposta;
import com.carlos.salaoApi.controller.common.exeption.MeuExeption;
import com.carlos.salaoApi.controller.dto.AgendaDTO;
import com.carlos.salaoApi.controller.mappers.AgendaMapper;
import com.carlos.salaoApi.model.Agenda;
import com.carlos.salaoApi.service.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agenda")
@RequiredArgsConstructor
public class AgendaController {
    private final AgendaService service;
    private  final AgendaMapper mapper = AgendaMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<?> salvarAgenda(@RequestBody @Valid AgendaDTO agendaDTO){
            Agenda agenda = mapper.toEntity(agendaDTO);
            Agenda agendaSalva = service.salvar(agenda);
            return ResponseEntity.ok(agendaSalva);

    }

    @GetMapping
    public List<AgendaDTO> listarAgendas() {
        return service.listar();
    }
}
